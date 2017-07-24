package com.ranv.Controller;

import com.cloudinary.Cloudinary;
import com.ranv.FulfillingDB.FulfillingDB;
import com.ranv.Model.DTO.ManualDTO;
import com.ranv.Model.DTO.TagDTO;
import com.ranv.Model.DTO.UserDTO;
import com.ranv.Model.ModelDB.Manual;
import com.ranv.Model.ModelDB.Tag;
import com.ranv.Model.ModelDB.User;
import com.ranv.Service.ManualService;
import com.ranv.Service.TagService;
import com.ranv.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
public class MainController {

    @Autowired
    private ManualService manualService;

    @Autowired
    private UserService userService;

    @Autowired
    private TagService tagService;

    @Autowired
    private FulfillingDB fulfillingDB;

    @Autowired
    private ManualDTO manualDTO;

    @Autowired
    private UserDTO userDTO;

    @Autowired
    private TagDTO tagDTO;

    @RequestMapping("/main")
    public User main(@RequestParam(value = "name", defaultValue = "World") String username) {
        return new User();
    }

    @RequestMapping("/manuals")
    public List<ManualDTO> manuals() {
        //    fulfillingDB.fulfillDB();
        List<Manual> manuals = manualService.findAll();
        return manualDTO.convertItems(manuals);
        // List<ManualDTO> manualDTOS=manualDTO.convertItems(manuals);

    }



    @RequestMapping("/users")
    public List<UserDTO> users() {
        List<User> users = userService.findAll();
        return userDTO.convertItems(users);
//        List<UserDTO> userDTOS=userDTO.convertItems(users);
//        return userDTOS;
    }

    @RequestMapping("/tags")
    public List<TagDTO> tags() {
        List<Tag> tags = tagService.findAll();
        List<TagDTO> tagDTOS=tagDTO.convertItems(tags);
        return tagDTOS;
    }

    @Autowired
    Cloudinary cloudinary;

    @RequestMapping("/image")
    public void image(){
        try {
            Map uploadResult= cloudinary.uploader().upload("C:\\Users\\Андрей\\Downloads\\Mario.jpg", com.cloudinary.utils.ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    public void login(){

    }
}
