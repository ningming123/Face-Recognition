package com.example.face.config.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //注册拦截器以及拦截请求路径（生效、不生效）
        registry.addInterceptor(new AuthorityInterceptor()).addPathPatterns("/face/**").excludePathPatterns("/listface/**");
        super.addInterceptors(registry);
    }
}
