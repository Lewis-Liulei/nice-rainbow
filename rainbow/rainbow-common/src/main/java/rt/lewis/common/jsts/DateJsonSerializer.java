package rt.lewis.common.jsts;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import rt.lewis.common.utils.DateUtil;
import rt.lewis.common.utils.SpecialDateTimeFormatter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;

public class DateJsonSerializer extends JsonSerializer<LocalDateTime> {
    @Override
    public void serialize(LocalDateTime date, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider)
            throws IOException {
        jsonGenerator.writeString(date.format(SpecialDateTimeFormatter.DEFAULT_DATE_TIME_FORMATTER));
    }
}
