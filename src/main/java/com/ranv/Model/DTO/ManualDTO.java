package com.ranv.Model.DTO;

import com.ranv.Model.ModelDB.Rating;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;


@Getter
@Setter
@Component
public class ManualDTO{

    private Long id;
    private String name;
    private String date;
    private String image;
    private String introduction;
    private String username;
    private boolean published;
    private List<String> tagNames;
    private Long rating;


    public void setRatingCustom(Set<Rating> ratings) {
        rating = 0L;
        for (Rating rat : ratings) {
            rating += rat.getValue();
        }
    }



}

