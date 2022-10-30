package com.example.ShowMakerCode.HandlerInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class LoginInterceptorConfig implements WebMvcConfigurer {
    @Autowired
    LoginHandlerInterceptor filter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(filter).addPathPatterns("/smk/admin/**").addPathPatterns("/smk/card/add/**")
                .addPathPatterns("/smk/card/wait-application")
                .excludePathPatterns("/smk/site/login","/smk/homepage");

    }

}
