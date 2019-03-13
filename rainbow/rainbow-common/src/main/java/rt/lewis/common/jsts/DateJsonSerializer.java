package rt.lewis.common.jsts;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import rt.lewis.common.utils.DateUtil;

import java.io.IOException;
import java.util.Date;

public class DateJsonSerializer extends JsonSerializer<Date> {
    @Override
    public void serialize(Date date, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(DateUtil.date2String(date,DateUtil.DATETIME_FORMAT));
    }
}
