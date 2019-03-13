package rt.lewis.common.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    private static final Logger logger= LogManager.getLogger(DateUtil.class);

    public static final String DATE_NOTSPACE_FORMAT = "yyyyMMdd";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String YEAR = "YYYY";
    public static final String YEAR_LAST = "yy";
    public static final String MONTH_LAST = "MM";
    public static final String DAY_LAST = "dd";

    public static final String DATE_YEAR_MONTH_FORMAT = "yyyyMM";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String TIME_HOURS_MINUTES = "HHmm";

    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_NOTSPACE_FORMAT = "yyyyMMddHHmmss";

    public static final String DATETIME_SIMPLE_DETAIL = "yyyyMMddHHmmssSSS";
    public static final String DATETIME_NORMAL_DETAIL = "yyyy-MM-dd HH:mm:ss.SSS";

    public static final String MAX_DATE = "2099-12-31";

    public static final String second = "s";

    public static final String MINUTE = "minute";

    public static final String HOUR = "hour";

    public static final String DAY = "day";

    private static final String JAN = "01", DEC = "12";




    /**
     * 字符串转化为时间，默认按yyyy-MM-dd HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public static final Date string2Date(String date,String format) throws ParseException {
        if(StringUtil.isBlank(format)){
            format=DATETIME_FORMAT;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        formatter.setLenient(false);
        return formatter.parse(date);
    }



    /**
     * 时间转化为字符串，默认按yyyy-MM-dd HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public final static String date2String(Date date,String format) {
        if(StringUtil.isBlank(format)){
            format=DATETIME_FORMAT;
        }
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(date);
    }
    /**
     * 字符串时间格式转化，依然返回字符串，默认按yyyy-MM-dd HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public static final String dateString2String(String date,String format) throws ParseException{
        Date date1=string2Date(date,format);
        return date2String(date1,format);
    }

    /**
     * Date时间格式转化，依然返回Date，默认按yyyy-MM-dd HH:mm:ss格式
     *
     * @param date
     * @return
     */
    public static final Date date2Date(Date date,String format) throws ParseException{
        String date1=date2String(date,format);
        return string2Date(date1,format);
    }

    /**
     * 返回指定的yyyyMMdd格式的当前日期字符串
     *
     * @return
     */
    public static String getCurrentDateString(String format) {
        Date date = getCurrentTimestamp();
        return date2String(date, format);
    }

    public static Date getDayBeforeOrAfter(Date day,int amount) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(day);
        cal.add(Calendar.DATE, amount);
        return cal.getTime();

    }

    public static Date getNextDay(Date day) {
       return getDayBeforeOrAfter(day,1);
    }

    public static Date getBeforeDay(Date day) {
        return getDayBeforeOrAfter(day,-1);
    }

    public static Timestamp getCurrentTimestamp() {

        return new Timestamp(System.currentTimeMillis());
    }

    /**
     * date比较大小
     *
     */

    public static final boolean dateEquals(Date date1,Date date2){
        if(date1==null&&date2==null){
            return true;
        }
        if(date1==null||date2==null){
            return false;
        }

        return date1.compareTo(date2)==0;
    }

    public static final boolean before(Date date1,Date date2){
        if(date1==null||date2==null){
            logger.error("StringUtil.before方法输入参数为空");
            throw new NullPointerException();
        }

        return date1.before(date2);
    }

    public static final boolean after(Date date1,Date date2){
        if(date1==null||date2==null){
            logger.error("StringUtil.after方法输入参数为空");
            throw new NullPointerException();
        }

        return date1.after(date2);
    }


}
