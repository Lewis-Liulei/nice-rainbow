package rt.lewis.common.config;

import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import rt.lewis.common.utils.DateUtil;
import rt.lewis.ext.format.DateFormatter;

import java.text.SimpleDateFormat;
import java.util.List;

@Configuration
@EnableWebMvc
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

    /*@Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter());
        // ...
    }*/

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder()
                .indentOutput(true)
                .dateFormat(new SimpleDateFormat(DateUtil.DATETIME_FORMAT))
                .modulesToInstall(new ParameterNamesModule());
        converters.add(new MappingJackson2HttpMessageConverter(builder.build()));
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }

    //responce.set('Access-Control-Allow-Origin', request.get('origin'));

/*
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://domain2.com")
                .allowedMethods("PUT", "DELETE")
                .allowedHeaders("header1", "header2", "header3")
                .exposedHeaders("header1", "header2")
                .allowCredentials(false).maxAge(3600);
    }*/
}