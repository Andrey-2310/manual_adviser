package com.ranv.Model.DTO;

import com.ranv.Model.ModelDB.Comment;
import com.ranv.Model.ModelDB.Medal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

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
    private Set<Medal> medals;
    private List<ManualDTO> manualDTOS;
    private Set<Comment> comments;


}
