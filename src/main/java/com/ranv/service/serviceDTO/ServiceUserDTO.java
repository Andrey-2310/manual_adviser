package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.UserDTO;
import com.ranv.Model.ModelDB.User;
import org.springframework.stereotype.Service;

@Service
public class ServiceUserDTO extends ServiceModelDTO<UserDTO, User> {
    @Override
    public UserDTO convertToItemDTO(User user) {
        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        userDTO.setCommentAmount((long) user.getComments().size());
        userDTO.setManualAmount((long) user.getManuals().size());
        return userDTO;
    }

    @Override
    protected User convertFromItemDTO(UserDTO item) {
        return null;
    }
}
