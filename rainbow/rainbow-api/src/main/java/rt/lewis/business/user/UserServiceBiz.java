package rt.lewis.business.user;

import rt.lewis.common.entity.user.User;
import java.util.List;

public interface UserServiceBiz {

    public String getString();

    public String setString();

    public User getUserById(String id);

    public List<User> getAllUser();

    public List<User> getListByPage();

    public String setRedisKey(String key);

    public String getRedisKey(String key);
}
