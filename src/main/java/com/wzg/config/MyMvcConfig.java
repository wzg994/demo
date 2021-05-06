package com.wzg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//如果你想diy一些定制化的功能，之哟啊写这个组件，然后将它交给springbot，他就会帮我们自动装配
//扩展springMVC alt+ins  dispatchservlet
//静态资源优先级 resources>static>public


//如果我们要扩展springmvc，官方建议我们这样做
@Configuration
//@EnableWebMvc //这玩意就是导入了一个雷：D饿了gatinWebMvcConfiguration：从容器中获取所有的webmvcconfig
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
    }
//ViewResolver实现了视图解析器接口的类，我们就可以把它看做视图解析器

/*    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/wzg").setViewName("test");
    }*/

/*    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    //自定义了一个视图解析器
    public static class MyViewResolver implements ViewResolver{

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }*/


}
