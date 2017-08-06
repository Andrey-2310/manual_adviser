package com.ranv.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class CloudinaryConfiguration {

    @Bean
    public Cloudinary getCloudinaryConnection(){
         Map config = ObjectUtils.asMap(
             "cloud_name", "diwv72pih",
                     "api_key", "799382978267317",
                     "api_secret", "gdF3K_obUVm3r049bV_zwmReYiY");
             return new Cloudinary(config);
         }
}
