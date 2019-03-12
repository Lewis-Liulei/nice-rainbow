package rt.lewis.common.entity.user;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 5753509972160575259L;
    private String id;
    private String name;
    private String address;
    private Integer status;
}
