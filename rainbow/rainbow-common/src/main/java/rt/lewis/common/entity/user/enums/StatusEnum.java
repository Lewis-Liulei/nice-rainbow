package rt.lewis.common.entity.user.enums;

import com.baomidou.mybatisplus.core.enums.IEnum;

public enum StatusEnum implements IEnum<Integer> {
    成功(0,"成功"),
    失败(1,"失败"),
    未知(2,"未知");

    private int status;
    private String desc;

    StatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return this.status;
    }
}
