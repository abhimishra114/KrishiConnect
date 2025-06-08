package com.example.KrishiConnect.config;

import com.cloudinary.Cloudinary;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Value("${cloudinary.url}")
    String cloudinaryUrl;

    @Bean
    Cloudinary cloudinary() {
        return new Cloudinary(cloudinaryUrl);
    }
}
