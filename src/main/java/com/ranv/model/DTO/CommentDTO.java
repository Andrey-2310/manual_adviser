package com.ranv.model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Getter
@Setter
@Component
public class CommentDTO {

    private Long id;
    private String text;
    private Date date;
    private String username;
    private Long userId;
    private Long stepId;
}
