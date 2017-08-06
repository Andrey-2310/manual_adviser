package com.ranv.service.serviceDTO;

import com.ranv.model.DB.User;
import com.ranv.model.DTO.UserExtendedDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceUserExtendedDTO extends ServiceModelDTO<UserExtendedDTO, User> {

    private ServiceManualDTO serviceManualDTO;
    private ServiceMedalDTO serviceMedalDTO;

    @Autowired
    public ServiceUserExtendedDTO(ServiceManualDTO serviceManualDTO, ServiceMedalDTO serviceMedalDTO) {
        this.serviceManualDTO = serviceManualDTO;
        this.serviceMedalDTO = serviceMedalDTO;
    }

    @Override
    public UserExtendedDTO convertToItemDTO(User user) {
        UserExtendedDTO userExtendedDTO = modelMapper.map(user, UserExtendedDTO.class);
        userExtendedDTO.setManualDTOS(serviceManualDTO.convertItems(new ArrayList<>(user.getManuals())));
        userExtendedDTO.setMedals(serviceMedalDTO.convertItems(new ArrayList<>(user.getMedals())));
        return userExtendedDTO;
    }

    @Override
    public User convertFromItemDTO(UserExtendedDTO userExtendedDTO) {
        return modelMapper.map(userExtendedDTO, User.class);
    }
}
