package rt.lewis.facade.test;

import org.springframework.web.bind.annotation.*;
import rt.lewis.common.entity.user.User;
import rt.lewis.common.response.RTSuccessReturnMessage;
import rt.lewis.common.response.ReturnMessage;

@RestController
@RequestMapping("/test")
public class TestFacade {


    @GetMapping("/testrm")
    public ReturnMessage testrm(){

        int a = 1/0;

        return new ReturnMessage();


    }
    @PostMapping("/ins")
    public User instertUser(@RequestBody User user){


        return user;
    }

}
