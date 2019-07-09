package com.juniors.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拓展Spring MVC 的功能
 * @author Juniors
 */
@Configuration
public class MyMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
        //super.addViewControllers(registry);

        registry.addViewController("/config").setViewName("success");
    }


    /**
     * 利用 Java 编码方式定义
     * 访问静态资源的路径解析
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//       super.addResourceHandlers(registry);

        registry.addResourceHandler("/static/**")
                .addRgesourceLocations("classpath:/static/");
    }
}
