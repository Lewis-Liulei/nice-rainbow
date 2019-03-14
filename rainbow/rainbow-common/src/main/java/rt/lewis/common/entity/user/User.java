package rt.lewis.common.entity.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import rt.lewis.common.entity.user.enums.StatusEnum;
import rt.lewis.common.jsts.DateJsonDeserializer;
import rt.lewis.common.jsts.DateJsonSerializer;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private static final long serialVersionUID = 5753509972160575259L;
    private String id;
    private String name;
    private String address;
    //private Integer status;
    private StatusEnum status;
    @JsonSerialize(using = DateJsonSerializer.class)
    @JsonDeserialize(using = DateJsonDeserializer.class)
    private Date ctime;
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date cdate;

    private Date cdt;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getCdate() {
        return cdate;
    }


    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public Date getCdt() {
        return cdt;
    }

    public void setCdt(Date cdt) {
        this.cdt = cdt;
    }
}
