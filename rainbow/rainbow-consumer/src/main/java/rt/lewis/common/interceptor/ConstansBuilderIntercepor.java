package rt.lewis.common.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
// extends HandlerInterceptorAdapter
public class ConstansBuilderIntercepor {
    private static final Logger logger = LogManager
            .getLogger(ConstansBuilderIntercepor.class);
    private static String MDC_KEY_REQ_ID = "requestId";
    //@Override
     public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestId = String.valueOf(UUID.randomUUID());
        MDC.put(MDC_KEY_REQ_ID,requestId);
        logger.info("=====>@preHandle：请求requestId为："+requestId);
        return true;
    }
    //@Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {

        //super.postHandle(request, response, handler, modelAndView);
    }

    //@Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        MDC.remove(MDC_KEY_REQ_ID);
        //super.afterCompletion(request, response, handler, ex);
    }
}
