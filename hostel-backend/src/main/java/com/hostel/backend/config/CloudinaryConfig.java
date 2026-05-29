package com.hostel.backend.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dhvqjfqmb",
                "api_key", "299145864259341",
                "api_secret", "m9BN_XtijD6l4z0YUbG-UBuQs50"
        ));
    }
}
