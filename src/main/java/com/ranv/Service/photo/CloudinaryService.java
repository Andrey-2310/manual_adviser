package com.ranv.Service.photo;

import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class CloudinaryService {
    @Autowired
    private Cloudinary cloudinary;

    public String getPhoto(String image) {
        try {
            return cloudinary.uploader().upload(image, com.cloudinary.utils.ObjectUtils.emptyMap()).get("url").toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
