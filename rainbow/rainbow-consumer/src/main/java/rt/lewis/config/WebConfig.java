package rt.lewis.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rt.lewis.interceptor.ConstansBuilderIntercepor;

/*@Configuration
@EnableWebMvc*/
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*// 注册拦截器
        InterceptorRegistration ir = registry.addInterceptor(new ConstansBuilderIntercepor());
        // 配置拦截的路径
        ir.addPathPatterns("/**");
        // 配置不拦截的路径
        ir.excludePathPatterns("/static/**","/templates/**");*/
    }
}