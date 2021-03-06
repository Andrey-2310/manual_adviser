package com.ranv.service.serviceDTO;

import com.ranv.model.DTO.UserDTO;
import com.ranv.model.DB.User;
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
