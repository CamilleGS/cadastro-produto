package com.fatec.cadastro_produto.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/ui/produtos/**") // Caminhos protegidos
                .excludePathPatterns("/login", "/cadastro", "/css/**", "/js/**", "/images/**"); // Libera login, cadastro e recursos
    }
}
