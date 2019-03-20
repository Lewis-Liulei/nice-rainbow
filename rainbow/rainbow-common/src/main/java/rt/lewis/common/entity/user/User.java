package rt.lewis.common.entity.user;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
//import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import rt.lewis.common.entity.user.enums.StatusEnum;
import rt.lewis.common.jsts.DateJsonDeserializer;
//import rt.lewis.common.jsts.DateJsonDeserializer;
import rt.lewis.common.jsts.DateJsonSerializer ;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
@Data
//@EqualsAndHashCode(callSuper = true)
//@NoArgsConstructor
@Accessors(chain = true)
//@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 5753509972160575259L;
    private Integer id;
    private String name;
    private String address;
    //private Integer status;
    private StatusEnum status;
    //@JsonSerialize(using = DateJsonSerializer.class)
    //@JsonDeserialize(using = DateJsonDeserializer.class)
    private LocalDateTime ctime;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cdate;

    private LocalDateTime cdt;



}
