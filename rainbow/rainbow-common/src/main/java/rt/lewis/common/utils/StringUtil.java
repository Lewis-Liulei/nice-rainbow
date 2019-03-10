package rt.lewis.common.utils;

public class StringUtil {

    public static boolean isBlank(String s) {
        return s == null
                || s.trim().equalsIgnoreCase("")
                || "null".equalsIgnoreCase(s)
                || "\"null\"".equalsIgnoreCase(s);
    }

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }
}
