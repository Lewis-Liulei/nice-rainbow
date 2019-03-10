package rt.lewis.common.snowflake;

import java.lang.management.ManagementFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rt.lewis.common.utils.NetUtil;

public class IDGenerator {

    private static final Logger logger = LogManager.getLogger(IDGenerator.class);
    private long workerId;
    private long datacenterId;
    private long sequence = 0L;
    private static final int BYTE_MASK = 255;
    private static final long twepoch = 1288834974657L;
    private static final long workerIdBits = 5L;
    private static final long datacenterIdBits = 5L;
    private static final long maxWorkerId = 31L;
    private static final long maxDatacenterId = 31L;
    private static final long sequenceBits = 12L;
    private static final long workerIdShift = 12L;
    private static final long datacenterIdShift = 17L;
    private static final long timestampLeftShift = 22L;
    private static final long sequenceMask = 4095L;
    private long lastTimestamp = -1L;
    private static final long LOCAL_NODE_ID;
    private static final long LOCAL_WORK_ID;
    private static final IDGenerator ID_WORKER;

    static {
        byte[] bytes = NetUtil.getLocalAddress().getAddress();
        int tmp = (bytes[0] & 255) << 24 | (bytes[1] & 255) << 16 | (bytes[2] & 255) << 8 | bytes[3] & 255;
        LOCAL_NODE_ID = Math.abs((long)tmp % 31L);
        LOCAL_WORK_ID = (long)getPID() % 31L;
        ID_WORKER = new IDGenerator(LOCAL_WORK_ID, LOCAL_NODE_ID);
    }

    public IDGenerator(long workerId, long dataCenterId) {
        if (workerId <= 31L && workerId >= 0L) {
            if (dataCenterId <= 31L && dataCenterId >= 0L) {
                this.workerId = workerId;
                this.datacenterId = dataCenterId;
                logger.info("IDGenerator : DataCenterId {}, WorkerId {}", new Object[]{this.datacenterId, this.workerId});
            } else {
                throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", 31L));
            }
        } else {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", 31L));
        }
    }

    public static int getPID() {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String pid = name.substring(0, name.indexOf("@"));
        return Integer.parseInt(pid);
    }

    public synchronized long nextId() {
        long timestamp = this.timeGen();
        if (timestamp < this.lastTimestamp) {
            logger.warn("clock is moving backwards. Rejecting requests until {}.", new Object[]{this.lastTimestamp});
            throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", this.lastTimestamp - timestamp));
        } else {
            if (this.lastTimestamp == timestamp) {
                this.sequence = this.sequence + 1L & 4095L;
                if (this.sequence == 0L) {
                    timestamp = this.tilNextMillis(this.lastTimestamp);
                }
            } else {
                this.sequence = 0L;
            }

            this.lastTimestamp = timestamp;
            return timestamp - 1288834974657L << 22 | this.datacenterId << 17 | this.workerId << 12 | this.sequence;
        }
    }

    protected long tilNextMillis(long lastTimestamp) {
        long timestamp;
        for(timestamp = this.timeGen(); timestamp <= lastTimestamp; timestamp = this.timeGen()) {
            ;
        }

        return timestamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static long genId() {
        return ID_WORKER.nextId();
    }
}