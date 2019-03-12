package rt.lewis.business;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import rt.lewis.business.user.UserService;
import rt.lewis.business.user.UserServiceBiz;
import rt.lewis.common.entity.user.User;

import java.util.List;

@Service
public class UserServiceBizImpl implements UserServiceBiz {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate template;

    @Override
    public String getString() {
        return "hello world";
    }

    @Override
    public String setString() {
        return "终于通了";
    }

    @Override
    public User getUserById(String id) {
        return userService.getUserById(id);
    }

    @Override
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @Override
    public List<User> getListByPage(){
        return userService.getListByPage();
    }

    @Override
    public String setRedisKey(String key) {
        return userService.setRedisKey(key);
    }

    @Override
    public String getRedisKey(String key) {
        return userService.getRedisKey(key);
    }

}
