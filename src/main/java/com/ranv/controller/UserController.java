package com.ranv.controller;

import com.ranv.model.DTO.UserDTO;
import com.ranv.model.DTO.UserExtendedDTO;
import com.ranv.model.DB.User;

import com.ranv.service.serviceDTO.ServiceUserDTO;
import com.ranv.service.serviceDTO.ServiceUserExtendedDTO;
import com.ranv.service.serviceModel.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class UserController {

    private final UserService userService;
    private final ServiceUserExtendedDTO serviceUserExtendedDTO;
    private final ServiceUserDTO serviceUserDTO;

    @Autowired
    public UserController(UserService userService, ServiceUserDTO serviceUserDTO,
                          ServiceUserExtendedDTO serviceUserExtendedDTO) {
        this.userService = userService;
        this.serviceUserDTO = serviceUserDTO;
        this.serviceUserExtendedDTO = serviceUserExtendedDTO;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping("/users")
    public List<UserDTO> users() {
        List<User> users = userService.findAll();
        return serviceUserDTO.convertItems(users);
//        List<UserDTO> userDTOS=userDTO.convertItems(users);
//        return userDTOS;
    }

    @RequestMapping("/users/{id}")
    public UserExtendedDTO extUsers(@PathVariable Long id) {
        User user = userService.findById(id);
        return serviceUserExtendedDTO.convertToItemDTO(user);
    }

        @RequestMapping(value = "/userprofile", method = RequestMethod.POST)
    public void updateUser(@RequestBody UserExtendedDTO userExtDTO) {
        userService.updateUser(serviceUserExtendedDTO.convertFromItemDTO(userExtDTO));
    }

}
