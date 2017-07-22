package com.ranv.Model.DTO;

import com.ranv.Model.ModelDB.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class UserDTO extends ModelDTO<UserDTO, User> {

    private Long id;
    private String username;
    private String identity;
    private Long roleId;


    @Override
    public UserDTO convertToItemDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        //  userDTO.setUserId(manual.getUser().getId());
        return userDTO;
    }

}
