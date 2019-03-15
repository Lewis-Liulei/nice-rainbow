package rt.lewis.common.jsts;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import rt.lewis.common.utils.DateUtil;
import rt.lewis.common.utils.SpecialDateTimeFormatter;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class DateJsonDeserializer extends JsonDeserializer<LocalDateTime> {

    //public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public LocalDateTime deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        return LocalDateTime.parse(jsonParser.getText(),
                    SpecialDateTimeFormatter.DEFAULT_DATE_TIME_FORMATTER);
    }

}
