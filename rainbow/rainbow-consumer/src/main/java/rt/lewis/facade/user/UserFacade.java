package rt.lewis.facade.user;

import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.lewis.api.biz.user.UserServiceBiz;
import rt.lewis.module.user.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserFacade {
    private static final Logger logger = LogManager
            .getLogger(UserFacade.class);
    @Reference
    private UserServiceBiz userServiceBiz;

    @GetMapping("/hello")
    public String getString(){
        logger.info("hello world!getString");
        return "helloworld";

    }

   /* @GetMapping("/setstr")
    public String setString(){
        return userServiceBiz.setString();

    }*/

    @GetMapping("/getUserById/{id}")
    public User setString(@PathVariable String id){
        logger.info("hello world!getUserById");
        return userServiceBiz.getUserById(id);

    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userServiceBiz.getAllUser();
    }

    @GetMapping("/getListByPage")
    public List<User> getListByPage(){
        return userServiceBiz.getListByPage();
    }
}
