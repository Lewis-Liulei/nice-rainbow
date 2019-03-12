package rt.lewis.common.exception;

//业务异常
public class RTBusinessException extends Exception{

    private static final long serialVersionUID = -6165367321295765272L;

    private String errorDescription;
    private String errorCode;

    public RTBusinessException(String errorDescription, String errorCode) {
        super(errorDescription);
        this.errorDescription = errorDescription;
        this.errorCode = errorCode;
    }

    public RTBusinessException(String errorDescription) {
        super(errorDescription);
        this.errorDescription = errorDescription;
    }

    public RTBusinessException(String errorDescription, Throwable t) {
        super(errorDescription, t);
        this.errorDescription = errorDescription;
    }

    public RTBusinessException(String code,String errorDescription, Throwable t) {
        super(errorDescription, t);
        this.errorDescription = errorDescription;
        this.errorCode = code;
    }
    public String getErrorDescription() {
        return this.errorDescription;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
