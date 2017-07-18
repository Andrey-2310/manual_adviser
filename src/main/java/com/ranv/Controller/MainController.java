package com.ranv.Controller;

import com.ranv.FulfillingDB.FulfillingDB;
import com.ranv.Model.DTO.ManualDTO;
import com.ranv.Model.DTO.UserDTO;
import com.ranv.Model.Manual;
import com.ranv.Model.User;
import com.ranv.Service.ManualService;
import com.ranv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Андрей on 16.07.2017.
 */
@RestController
public class MainController {

    @Autowired
    private ManualService manualService;

    @Autowired
    private UserService userService;

    @Autowired
    private FulfillingDB fulfillingDB;

    @Autowired
    private ManualDTO manualDTO;

    @Autowired
    private UserDTO userDTO;

    @RequestMapping("/main")
    public User main(@RequestParam(value = "name", defaultValue = "World") String username) {
        return new User();
    }

    @RequestMapping("/manual")
    public List<UserDTO> manual() {
        //    fulfillingDB.fulfillDB();
        List<Manual> manuals = manualService.findAll();
        List<User> users = userService.findAll();
        List<ManualDTO> manualDTOS=manualDTO.convertItems(manuals);
        List<UserDTO> userDTOS=userDTO.convertItems(users);
        return userDTOS;
    }
}
