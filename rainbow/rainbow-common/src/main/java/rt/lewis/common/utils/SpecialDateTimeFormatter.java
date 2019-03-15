package rt.lewis.common.utils;


import java.time.OffsetDateTime;
import java.time.chrono.IsoChronology;
import java.util.Locale;

import java.time.LocalDateTime;
import java.time.chrono.JapaneseChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class SpecialDateTimeFormatter {

    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER=
            DateTimeFormatter.ofPattern("yyyy-MM-dd");
    ////HH:mm:ss
    public static final DateTimeFormatter DEFAULT_TIME_FORMATTER=
            DateTimeFormatter.ofPattern("HH:mm:ss");

    //yyyy-MM-dd HH:mm:ss
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");;

    public static final DateTimeFormatter OFFSET_FORMATTER;

    static {
        OFFSET_FORMATTER = new DateTimeFormatterBuilder()
            .parseCaseInsensitive()
            .append(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            //.optionalStart()
            //.appendPattern(".SSS")
            //.optionalEnd()
            /*.optionalStart()
            .appendZoneOrOffsetId()
            .optionalEnd()*/
            .optionalStart()
            .appendOffset("+HHMMss", "Z")
            .optionalEnd()
            .toFormatter();
    }
    public static void main(String[] args) {

    }

}
