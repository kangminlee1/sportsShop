package project.sportsShop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import project.sportsShop.interceptor.SessionInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // 인터셉터를 추가하기 위한 WebConfig 설정

    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor);
    }
}
