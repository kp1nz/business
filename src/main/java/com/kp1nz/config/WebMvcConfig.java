//package com.kp1nz.config;
//
//import com.kp1nz.utils.PropertiesUtils;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @author kp1nz
// * @create 2019-01-09 12:40
// */
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler(PropertiesUtils.readByKey("pathPatterns")).addResourceLocations(PropertiesUtils.readByKey("imageHost"));
//    }
//}
