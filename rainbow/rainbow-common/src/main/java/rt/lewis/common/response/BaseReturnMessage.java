package rt.lewis.common.response;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseReturnMessage implements Serializable {

	private static final long serialVersionUID = 5089551585479055161L;

	protected String type;

	protected String typeDescribe;

	protected String code;

	protected String unifiedCode;

	protected String message;

	public Object getContext() {
		return context;
	}

	public void setContext(Object context) {
		this.context = context;
	}

	protected Object context;

	//protected List<String> errorList = new ArrayList<String>();

	public BaseReturnMessage() {
	}

	public BaseReturnMessage(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public BaseReturnMessage(String type, String code, String message) {
		super();
		this.type = type;
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/*public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
*/
	public String getUnifiedCode() {
		return unifiedCode;
	}

	public void setUnifiedCode(String unifiedCode) {
		this.unifiedCode = unifiedCode;
	}

	public String getTypeDescribe() {
		return typeDescribe;
	}

	public void setTypeDescribe(String typeDescribe) {
		this.typeDescribe = typeDescribe;
	}

	/*public String toJson() {
		return JsonUtil.toJSON(this);
	}*/

	/*public Map<String, Object> getContext() {
		return context;
	}

    public void setContext(Map<String, Object> context) {
		this.context = context;
	}*/

	/*public boolean hasError() {
		return (errorList != null && !errorList.isEmpty()) || (code != null && !code.isEmpty() && !MvcConstants.MVC_RETURN_RESULT_SUCCESS_CODE.equals(code));
	}*/
	
	@Override
	public String toString() {
		return "BaseReturnMessage{" +
            "type=" + type + 
            ", typeDescribe=" + typeDescribe + 
            ", code=" + code + 
            ", unifiedCode=" + unifiedCode + 
            ", message=" + message + 
            ", context=" + context+
            /*", errorList=" + errorList + */
            '}';
	}
	/*
	private Map splitContext(Map context) {
		//log打印过滤菜单数据
		if (context.containsKey("menuMap")) {
			HashMap newContext = new HashMap(context); 
			newContext.remove("menuMap"); 
			return newContext;
		}
		return context;
	}*/
	
}
