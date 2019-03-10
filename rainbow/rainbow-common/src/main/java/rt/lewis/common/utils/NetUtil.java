package rt.lewis.common.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.NetworkInterface;
import java.net.Socket;
import java.util.Enumeration;
import java.util.regex.Pattern;

public class NetUtil {
    private static final Logger logger = LogManager.getLogger(NetUtil.class);

    private static volatile InetAddress LOCAL_ADDRESS = null;
    public static final String LOCALHOST = "127.0.0.1";
    public static final String ANYHOST = "0.0.0.0";
    private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

    public static final String LOCAL_IP = getLocalHost();

    public static InetAddress getLocalAddress() {
        if (LOCAL_ADDRESS != null) {
            return LOCAL_ADDRESS;
        }
        InetAddress localAddress = getLocalAddress0();
        LOCAL_ADDRESS = localAddress;
        return localAddress;
    }

    public static String getLocalHost() {
        InetAddress address = getLocalAddress();
        return ((address == null) ? "127.0.0.1" : address.getHostAddress());
    }

    private static boolean isValidAddress(InetAddress address) {
        if ((address == null) || (address.isLoopbackAddress())) {
            return false;
        }
        String name = address.getHostAddress();
        return ((name != null) && (!("0.0.0.0".equals(name)))
                && (!("127.0.0.1".equals(name))) && (IP_PATTERN.matcher(name)
                .matches()));
    }

    private static InetAddress getLocalAddress0() {
        InetAddress localAddress = null;
        try {
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
        } catch (Throwable e) {
            logger.warn("Failed to retrieving ip address, " + e.getMessage());
        }
        try {
            Enumeration interfaces = NetworkInterface.getNetworkInterfaces();
            while ((interfaces != null) && (interfaces.hasMoreElements())) {
                try {
                    NetworkInterface network = (NetworkInterface) interfaces
                            .nextElement();
                    Enumeration addresses = network.getInetAddresses();
                    while ((addresses != null) && (addresses.hasMoreElements())) {
                        try {
                            InetAddress address = (InetAddress) addresses
                                    .nextElement();
                            if (isValidAddress(address)) {
                                return address;
                            }
                        } catch (Throwable e) {
                            logger.warn("Failed to retrieving ip address, " + e.getMessage());
                        }
                    }
                } catch (Throwable e) {
                    logger.warn("Failed to retrieving ip address, "
                            + e.getMessage());
                }
            }
        } catch (Throwable e) {
            logger.warn(
                    "Failed to retrieving ip address, " + e.getMessage());
        }
        logger.warn("Could not get local host ip address, will use 127.0.0.1 instead.");
        return localAddress;
    }

    public static boolean isConnectAble(String all, int timeout) {
        if ((!(StringUtil.isEmpty(all))) && (timeout > 0)) {
            try {
                String[] str = all.split("/")[0].split(":", 2);
                return isConnectAble(str[0], Integer.parseInt(str[1]), timeout);
            } catch (Throwable e) {
            }
        }
        return false;
    }

    public static boolean isConnectAble(String host, int port, int timeout) {
        boolean isReachable = false;
        Socket socket = null;
        try {
            socket = new Socket();

            InetSocketAddress endpointSocketAddr = new InetSocketAddress(host,
                    port);
            socket.connect(endpointSocketAddr, timeout);
            isReachable = true;
        } catch (Throwable e) {
            logger.warn("isConnectAble fail" + e.getMessage());
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (Throwable e) {
                }
            }
        }
        return isReachable;
    }

//	public static String getRemoteAddr(HttpServletRequest request) {
//		try {
//			String ip = StringUtils.trim(request.getHeader("X-Forwarded-For"));
//			if (StringUtils.isBlank(ip))
//				ip = StringUtils.trim(request.getHeader("X-Real-IP"));
//			else if (StringUtils.isBlank(ip)) {
//				ip = request.getRemoteAddr();
//			}
//			return ip.split(",")[0];
//		} catch (Exception e) {
//		}
//		return request.getRemoteAddr();
//	}
}