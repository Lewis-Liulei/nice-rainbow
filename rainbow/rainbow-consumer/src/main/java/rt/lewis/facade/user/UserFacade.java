package rt.lewis.facade.user;

import com.alibaba.dubbo.config.annotation.Reference;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.lewis.business.user.UserServiceBiz;
import rt.lewis.common.entity.user.User;
import rt.lewis.common.response.ReturnMessage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserFacade {
    private static final Logger logger = LogManager
            .getLogger(UserFacade.class);
   /* @Reference
    private UserServiceBiz userServiceBiz;*/

    @GetMapping("/hello")
    public String getString(){
        logger.info("hello world!getString");
        return "helloworld";

    }

   /* @GetMapping("/setstr")
    public String setString(){
        return userServiceBiz.setString();

    }*/

   /* @GetMapping("/getUserById/{id}")
    public User setString(@PathVariable String id){
        logger.info("hello world!getUserById");
        return userServiceBiz.getUserById(id);

    }*/
   @GetMapping("/testrm")
   public ReturnMessage testrm(){

       int a = 1/0;

       return new ReturnMessage();


   }

    @GetMapping("/retest")
    public Map<String ,Object> retmap(){

        Map<String,Object> map = new HashMap<>();
        User user = new User();
        /*private String id;
        private String name;
        private String address;
        private Integer status;*/
        /*user.setId("22");
        user.setName("sdfdfds");
        user.setAddress("sdfdfds");
        user.setStatus(3);*/
        map.put("context",user);
        return  map;

    }



 /*   @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userServiceBiz.getAllUser();
    }*/
/*
    @GetMapping("/getListByPage")
    public List<User> getListByPage(){
        return userServiceBiz.getListByPage();
    }*/
/**
    @GetMapping("/setRedisKey/{key}")
    public String setRedisKey(@PathVariable String key){
        return userServiceBiz.setRedisKey(key);
    }
    @GetMapping("/getRedisKey/{key}")
    public String getRedisKey(@PathVariable String key){
        return userServiceBiz.getRedisKey(key);
    }*/
}
