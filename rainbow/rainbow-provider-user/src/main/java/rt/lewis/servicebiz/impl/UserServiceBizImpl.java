package rt.lewis.servicebiz.impl;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import rt.lewis.api.biz.user.UserServiceBiz;
import rt.lewis.api.daoservice.user.UserService;
import rt.lewis.module.user.User;

import java.util.List;

@Service
public class UserServiceBizImpl implements UserServiceBiz {

    @Autowired
    private UserService userService;

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

}
