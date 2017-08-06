package com.ranv.model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;


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
    private Long userId;
    private boolean published;
    private List<TagDTO> tags;
    private List<StepDTO> steps;
    private int rating;

}

