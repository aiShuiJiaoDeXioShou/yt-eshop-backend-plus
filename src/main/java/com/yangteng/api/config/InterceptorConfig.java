package com.yangteng.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    //文件夹绝对路径
    @Value("${file.upload.abpath}")
    private String abpath;

    //文件夹url
    @Value("${file.upload.urlpath}")
    private String ulrpath;

    @Value("${file.path}")
    private String path;

    @Value("${file.avatar}")
    private String avatar;

    public InterceptorConfig() {
        System.out.println("注册进来了=====================");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        String avatarUtl = "file:" + avatar.replace("\\","/");
        String pathUtl = "file:" + path.replace("\\","/");
        registry.addResourceHandler("/avatar/**").addResourceLocations(avatarUtl).setCachePeriod(0);
        registry.addResourceHandler("/file/**").addResourceLocations(pathUtl).setCachePeriod(0);
        registry.addResourceHandler(ulrpath).addResourceLocations("file:"+abpath);
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
    }
}
