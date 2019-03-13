package rt.lewis.common.response;

import rt.lewis.common.dict.MvcConstant;

public class RTSuccessReturnMessage extends ReturnMessage{

    private static final long serialVersionUID = 6177580529758516349L;

    public RTSuccessReturnMessage() {
        super(MvcConstant.MVC_RETURN_TYPE_RT,MvcConstant.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstant.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
    }

    public  RTSuccessReturnMessage(Object object) {
        super(MvcConstant.MVC_RETURN_TYPE_RT,MvcConstant.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstant.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
        context=object;
    }

	/*public  RTSuccessReturnMessage(Object obj) {
		super(MvcConstant.MVC_RETURN_TYPE_RT,MvcConstant.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstant.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
		if (null != obj) {
			this.context.putAll(BeanUtils.toMap(obj));
		}
	}	*/

	/*public RTSuccessReturnMessage(String key,Object obj) {
		super(MvcConstant.MVC_RETURN_TYPE_RT,MvcConstant.MVC_RETURN_RESULT_SUCCESS_CODE,MvcConstant.MVC_RETURN_RESULT_SUCCESS_MESSAGE);
		this.context.put(key, obj);
	}*/

}
