package xyz.arklight.nCovNews.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 对整个app进行配置
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    /**
     * 配置admin路由
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/admin").setViewName("TextStorageList");
    }
}
