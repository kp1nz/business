package com.neuedu.common;

import com.neuedu.controller.common.intecepter.AuthorityInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kp1nz
 * @create 2019-01-17 14:59
 */
//表明是配置类
@SpringBootConfiguration
public class MySpringMVCConfig extends WebMvcConfigurerAdapter {
    @Autowired
    AuthorityInterceptor authorityInterceptor;


    /**
     * 自定义拦截器
     * 继承 WebMvcConfigurerAdapter 重写addInterceptors()
     * @param registry  记录 所有路径及其子路径
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludeList = new ArrayList<String>();
        excludeList.add("/manage/user/login.do");


        List<String> addList = new ArrayList<String>();
        addList.add("/manage/**");
        registry.addInterceptor(authorityInterceptor).addPathPatterns(addList).excludePathPatterns(excludeList);
    }
}
