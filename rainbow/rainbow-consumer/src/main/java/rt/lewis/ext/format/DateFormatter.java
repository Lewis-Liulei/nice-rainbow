package rt.lewis.ext.format;

import org.springframework.format.Formatter;
import rt.lewis.common.utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateFormatter implements Formatter<Date> {


    @Override
    public Date parse(String s, Locale locale) throws ParseException {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        return DateUtil.string2Date(s,pattern);
    }

    @Override
    public String print(Date date, Locale locale) {
        return DateUtil.date2String(date,null);
    }
}
