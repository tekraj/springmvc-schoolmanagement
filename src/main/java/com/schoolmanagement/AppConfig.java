package com.schoolmanagement;
import com.schoolmanagement.interceptor.AuthenticationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author tek
 */

@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       
        registry.addInterceptor(getAuthenticationInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login"); 
    }
    @Bean
    AuthenticationInterceptor getAuthenticationInterceptor() {
        return new AuthenticationInterceptor();
    }
    
}
