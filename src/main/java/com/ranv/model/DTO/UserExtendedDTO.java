package com.ranv.model.DTO;

import com.ranv.model.DB.Comment;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class UserExtendedDTO {


    private Long id;
    private String username;
    private String identity;
    private String image;
    private String date;
    private String origin;
    private Long roleId;
    private List<MedalDTO> medals;
    private List<ManualDTO> manualDTOS;
    private List<Comment> comments;


}
