package rt.lewis.common.utils;

import javax.xml.bind.SchemaOutputResolver;
import java.util.regex.Pattern;

/**
 * 正则校验
 *
 */
public class RegexValidateUtil {

    public static final String MOBILEPHNOE_REGEX="^\\d{11}$";


    public static final boolean valiPhoneNum(String phoneNum){

        return matches(MOBILEPHNOE_REGEX,phoneNum);
    }

    /**
     * 公用方法
     * @param regex
     * @param content
     * @return
     */

    public static final boolean matches(String regex,String content){

        return Pattern.matches(regex,content);
    }

    /*public static void main(String[] args) {
        System.out.println(valiPhoneNum("645546464"));
    }*/

}
