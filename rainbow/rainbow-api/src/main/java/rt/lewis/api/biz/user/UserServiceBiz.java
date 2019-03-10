package rt.lewis.api.biz.user;

import rt.lewis.module.user.User;

import java.util.List;

public interface UserServiceBiz {

    public String getString();

    public String setString();

    public User getUserById(String id);

    public List<User> getAllUser();

    public List<User> getListByPage();
}
