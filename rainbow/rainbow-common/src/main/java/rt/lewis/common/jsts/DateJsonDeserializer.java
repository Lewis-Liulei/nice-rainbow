package rt.lewis.common.jsts;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import rt.lewis.common.utils.DateUtil;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateJsonDeserializer extends JsonDeserializer<Date> {

    //public static final SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException, JsonProcessingException {
        Date date=null;
        try {
            date=DateUtil.string2Date(jsonParser.getText(), DateUtil.DATETIME_FORMAT);
        } catch (ParseException e) {
            e.printStackTrace();

        }
        return date;
    }

}
