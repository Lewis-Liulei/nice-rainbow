package rt.lewis.filter.dubbo;


import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcContext;
import com.alibaba.dubbo.rpc.RpcException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.IdGenerator;
import rt.lewis.common.snowflake.IDGenerator;
import rt.lewis.common.utils.StringUtil;

import javax.annotation.PostConstruct;
import java.util.Map;

@Component
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER }, order = 10)
public class ConsumerLogHelperFilter implements Filter {
    public static final String REQUEST_ID = "requestId";
    private static final Logger logger = LogManager.getLogger(ConsumerLogHelperFilter.class);
    /*
    @Value("#{invokerconfig}")
    private Map<String,String> invokerconfig;

    public Map<String, String> getInvokerconfig() {
        return invokerconfig;
    }*/
/*
    public void setInvokerconfig(Map<String, String> invokerconfig) {
        this.invokerconfig = invokerconfig;
    }*/

    @PostConstruct
    public void init() {
        logger.info("===>ConsumerLogHelperFilter初始化成功");
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation)
            throws RpcException {

        boolean isConsumer = isConsumer(invoker.getUrl());
        String requestId = RpcContext.getContext().getAttachment(REQUEST_ID);

        if (isConsumer) {
            if (StringUtil.isBlank(requestId)) {
                requestId= String.valueOf(IDGenerator.genId());
                RpcContext.getContext().setAttachment(REQUEST_ID, requestId);
                MDC.put(REQUEST_ID, requestId);
            }
        } else {
            if (!StringUtil.isBlank(requestId)) {
                MDC.put(REQUEST_ID, requestId);
            }
        }
        try {
            if (!StringUtil.isBlank(requestId) && logger.isDebugEnabled()) {
                logger.debug("ConsumerLogHelperFilter.requestId:{}", requestId);
            }
            Result localResult = invoker.invoke(invocation);

            return localResult;
        } finally {
            if (!isConsumer) {
                MDC.remove(requestId);
            }
        }
    }

    private boolean isConsumer(URL url) {
        return Constants.CONSUMER.equals(url.getParameter(Constants.SIDE_KEY));
    }
}