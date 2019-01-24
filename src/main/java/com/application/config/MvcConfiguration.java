package com.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter{

@Override
public void addViewControllers(ViewControllerRegistry registry) {
    System.out.println("in mvc config");
    registry.addViewController("/").setViewName("forward:index.html");
}

@Override
public void configureDefaultServletHandling(
        DefaultServletHandlerConfigurer configurer) {
    System.out.println("configure serve handling");
    configurer.enable();
}  

@Bean
InternalResourceViewResolver internalResourceViewResolver () {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/jsp/");
    viewResolver.setSuffix(".jsp");
    return viewResolver;
}
}