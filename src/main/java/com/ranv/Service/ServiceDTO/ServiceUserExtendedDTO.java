package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.UserExtendedDTO;
import com.ranv.Model.ModelDB.User;
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
        userExtendedDTO.setRoleId(user.getRole().getId());
        return userExtendedDTO;
    }

    @Override
    public User convertFromItemDTO(UserExtendedDTO userExtendedDTO) {
        return modelMapper.map(userExtendedDTO, User.class);
    }
}
