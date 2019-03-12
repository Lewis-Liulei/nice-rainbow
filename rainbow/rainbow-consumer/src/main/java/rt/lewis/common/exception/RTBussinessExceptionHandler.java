package rt.lewis.common.exception;

//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import rt.lewis.common.dict.MvcConstant;
import rt.lewis.common.response.ReturnMessage;
import rt.lewis.facade.user.UserFacade;

@ControllerAdvice(annotations = RestController.class)
public class RTBussinessExceptionHandler //extends ResponseEntityExceptionHandler {
{
    private static final Logger logger = LogManager
            .getLogger(RTBussinessExceptionHandler.class);
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @Nullable
    public final ReturnMessage handleException(Exception ex, WebRequest request) throws Exception {
        logger.error("异常",ex);
        //ex.printStackTrace();
        if(ex instanceof RTBusinessException){
            throw ex;

        }
        return  new ReturnMessage(MvcConstant.MVC_RETURN_RESULT_WARN_CODE,MvcConstant.MVC_RETURN_RESULT_WARN_MESSAGE);

    }
/*
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleMyException(Exception ex, WebRequest request) throws Exception {
        ex.printStackTrace();
        if(ex instanceof RTBusinessException){
            throw ex;

        }
        ReturnMessage message = new ReturnMessage(MvcConstant.MVC_RETURN_RESULT_WARN_CODE, MvcConstant.MVC_RETURN_RESULT_WARN_MESSAGE);
        return super.handleExceptionInternal(ex, message, new HttpHeaders(), HttpStatus.OK, request);
    }*/

}
