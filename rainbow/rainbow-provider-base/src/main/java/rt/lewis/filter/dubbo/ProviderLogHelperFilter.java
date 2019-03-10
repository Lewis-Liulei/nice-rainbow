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
import org.springframework.stereotype.Component;
import rt.lewis.common.utils.StringUtil;

import javax.annotation.PostConstruct;

@Component
@Activate(group = {Constants.PROVIDER, Constants.CONSUMER}, order = 10)
public class ProviderLogHelperFilter implements Filter {
    //public static final String REQUEST_ID_DEF = "requestId";
    public static final String REQUEST_ID = "requestId";
    private static final Logger logger = LogManager.getLogger(ProviderLogHelperFilter.class);

    public ProviderLogHelperFilter() {}

    @PostConstruct
    public void init() {
        logger.info("===>ProviderLogHelperFilter初始化成功");
    }
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        logger.debug("ProviderLogHelperFilter.requestId:{}"+"15154131");
        boolean isConsumer = this.isConsumer(invoker.getUrl());
        String requestId = RpcContext.getContext().getAttachment(REQUEST_ID);
        if (isConsumer) {
            if (StringUtil.isBlank(requestId)) {
                RpcContext.getContext().setAttachment(REQUEST_ID, MDC.get(REQUEST_ID));
            }
        } else if (!StringUtil.isBlank(requestId)) {
            MDC.put(REQUEST_ID, requestId);
        }

        Result localResult;
        try {
            if (!StringUtil.isBlank(requestId) && logger.isDebugEnabled()) {
                logger.debug("ProviderLogHelperFilter.requestId:{}", requestId);
            }
            localResult = invoker.invoke(invocation);
        } finally {
            if (!isConsumer) {
                MDC.remove(REQUEST_ID);
            }
        }

        return localResult;
    }

    protected boolean isConsumer(URL url) {

        return Constants.CONSUMER.equals(url.getParameter(Constants.SIDE_KEY));
    }
}
