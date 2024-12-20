package com.clush.calendar;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/calendar/**")  // 모든 API 경로에 대해 CORS 허용
                .allowedOrigins("http://localhost:3000")  // 실제 클라이언트 URL에 맞게 수정
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
