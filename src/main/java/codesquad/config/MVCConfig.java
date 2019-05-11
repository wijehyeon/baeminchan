package codesquad.config;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class MVCConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        registry.addViewController("/users/form").setViewName("users/form");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/users/join").setViewName("join");
        registry.addViewController("/users/loginForm").setViewName("login");


    }
}
