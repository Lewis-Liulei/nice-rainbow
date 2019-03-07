package rt.lewis;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDubbo
//@ComponentScan(basePackages = "rt.lewis.facade.user")
public class RainbowConsumerApplication {

    public static void main(String[] args) {

        SpringApplication.run(RainbowConsumerApplication.class, args);
    }

}
