package com.ranv.model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class UserDTO {

    private Long id;
    private String username;
    private String identity;
    private String role;
    private String image;
    private Long manualAmount;
    private Long commentAmount;


}
