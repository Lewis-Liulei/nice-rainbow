package rt.lewis.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import rt.lewis.module.user.User;

public interface UserMapper extends BaseMapper<User> {

    public User getUserById(String id);
}
