package com.qiusuo.herokuspringdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /*
    So first it configures some beans. Configuration is called for bean
    configurations. Those beans are injected in some other methods in spring
    So in our case, the bean configed is CorsRegistry. We also care when is this
    method called. Spring finds all those stuff which implements certain interfaces.
    In this case, WebMvcConfigurer. Then when its initializating some other beans,
    it calls this method.

    Now we care when is corsregistry initialized.
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}
