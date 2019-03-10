package rt.lewis.api.daoservice.user;

import rt.lewis.module.user.User;

import java.util.List;

public interface UserService {

    public User getUserById(String id);

    public List<User> getAllUser();

    public List<User> getListByPage();
    
}
