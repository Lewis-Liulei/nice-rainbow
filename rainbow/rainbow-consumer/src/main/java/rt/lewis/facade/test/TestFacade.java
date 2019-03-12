package rt.lewis.facade.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rt.lewis.common.response.ReturnMessage;

@RestController
@RequestMapping("/test")
public class TestFacade {



    @GetMapping("/testrm")
    public ReturnMessage testrm(){

        int a = 1/0;

        return new ReturnMessage();


    }

}
