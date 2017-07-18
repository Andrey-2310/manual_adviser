package com.ranv.Model.DTO;

import com.ranv.Model.User;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
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
        UserDTO userDTO = new ModelMapper().map(user, UserDTO.class);
        //  userDTO.setUserId(manual.getUser().getId());
        return userDTO;
    }

}
