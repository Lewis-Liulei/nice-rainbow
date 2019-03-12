package rt.lewis.common.response;


public class ReturnMessage extends BaseReturnMessage {

	private static final long serialVersionUID = -7657459867510594977L;

	//protected String atoken;

	public ReturnMessage() {
		super();
	}
	
	public ReturnMessage(String returnCode, String message) {
		super(returnCode, message);
	}
	
	public ReturnMessage(String type, String code, String message) {
		super(type, code, message);
	}

	//public String getAtoken() {
		//return atoken;
	//}

	//public void setAtoken(String atoken) {
		//this.atoken = atoken;
	//}

	
	/*@Override
	public String toString() {
		return "ReturnMessage{" +
        "atoken=" + atoken + 
        '}' + super.toString();
	}*/
}
