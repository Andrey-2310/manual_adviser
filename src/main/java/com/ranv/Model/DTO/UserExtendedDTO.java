package com.ranv.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ranv.Model.ModelDB.Comment;
import com.ranv.Model.ModelDB.Medal;
import com.ranv.Model.ModelDB.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Component
public class UserExtendedDTO extends ModelDTO<UserExtendedDTO, User> {

    @Autowired
    @JsonIgnore
    private ManualDTO manualDTO;

    private Long id;
    private String username;
    private String identity;
    private String image;
    private String date;
    private String origin;
    private Set<Medal> medals;
    private List<ManualDTO> manualDTOS;
    private Set<Comment> comments;


    @Override
    public UserExtendedDTO convertToItemDTO(User user) {
        UserExtendedDTO userExtendedDTO = modelMapper.map(user, UserExtendedDTO.class);
        userExtendedDTO.manualDTOS=manualDTO.convertItems(new ArrayList<>(user.getManuals()));
        return userExtendedDTO;
    }

    public User convertFromItemDTO(UserExtendedDTO userExtendedDTO){
        return modelMapper.map(userExtendedDTO, User.class);
    }
}
