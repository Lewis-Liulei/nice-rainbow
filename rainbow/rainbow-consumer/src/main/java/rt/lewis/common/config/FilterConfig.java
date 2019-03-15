package rt.lewis.common.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import rt.lewis.common.filter.CORSFilter;

//@Configuration
public class FilterConfig {
    //@Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.addUrlPatterns("/**");
        CORSFilter filter = new CORSFilter();
        registration.setFilter(filter);
        registration.setName("corsFilter");
        return registration;
    }
}
