package com.ranv.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class MedalDTO {

    private Long id;
    private String name;
    private String text;
    private String image;
}
