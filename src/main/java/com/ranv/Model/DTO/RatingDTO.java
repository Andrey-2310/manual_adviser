package com.ranv.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class RatingDTO {

    private Long user;
    private Long manual;
    private Long value;


}
