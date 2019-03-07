package rt.lewis.facade.user;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.lewis.api.biz.user.UserServiceBiz;

@RestController
@RequestMapping("/user")
public class UserFacade {

    @Reference
    private UserServiceBiz userServiceBiz;

    @GetMapping("/hello")
    public String getString(){

        return userServiceBiz.getString();

    }

    @GetMapping("/setstr")
    public String setString(){
        return userServiceBiz.setString();

    }
}
