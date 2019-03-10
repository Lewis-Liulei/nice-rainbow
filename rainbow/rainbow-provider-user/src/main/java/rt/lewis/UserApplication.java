package rt.lewis;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubbo
//@ComponentScan("rt.lewis")
public class UserApplication {
    public static void main(String[] args) {

        /*ApplicationContext ctx = new SpringApplicationBuilder(UserApplication.class)
                .web(WebApplicationType.SERVLET)//web项目
                .run(args);*/
        SpringApplication.run(UserApplication.class,args);
    }
}
