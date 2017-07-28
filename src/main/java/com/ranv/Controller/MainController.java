package com.ranv.Controller;

import com.cloudinary.Cloudinary;
import com.ranv.FulfillingDB.FulfillingDB;
import com.ranv.Model.DTO.*;
import com.ranv.Model.ModelDB.Manual;
import com.ranv.Model.ModelDB.Tag;
import com.ranv.Model.ModelDB.User;
import com.ranv.Repository.FulltextSearch.HibernateSearch;
import com.ranv.Service.ServiceDTO.*;
import com.ranv.Service.ServiceModel.ManualService;
import com.ranv.Service.ServiceModel.RatingService;
import com.ranv.Service.ServiceModel.TagService;
import com.ranv.Service.ServiceModel.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
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
    private ServiceUserExtendedDTO serviceUserExtendedDTO;

    @Autowired
    private ServiceUserDTO serviceUserDTO;

    @Autowired
    private ServiceTagDTO serviceTagDTO;

    @Autowired
    private ServiceRatingDTO serviceRatingDTO;

    @Autowired
    private ServiceManualDTO serviceManualDTO;


    @RequestMapping("/manuals")
    public List<ManualDTO> manuals() {
        //  fulfillingDB.fulfillDB();
        List<Manual> manuals = manualService.findAll();
        return serviceManualDTO.convertItems(manuals);
        // List<ManualDTO> manualDTOS=manualDTO.convertItems(manuals);

    }

    @RequestMapping("/publishedmanuals")
    public List<ManualDTO> publishedManuals() {
        List<Manual> manuals = manualService.findPublished();
        return serviceManualDTO.convertItems(manuals);
    }

    @RequestMapping("/users")
    public List<UserDTO> users() {
        List<User> users = userService.findAll();
        return serviceUserDTO.convertItems(users);
//        List<UserDTO> userDTOS=userDTO.convertItems(users);
//        return userDTOS;
    }

    @RequestMapping("/users/{id}")
    public UserExtendedDTO extUsers(@PathVariable Long id) {
        User user = userService.findOne(id);
        return serviceUserExtendedDTO.convertToItemDTO(user);
    }

    @RequestMapping("/tags")
    public List<TagDTO> tags() {
        List<Tag> tags = tagService.findAll();
        List<TagDTO> tagDTOS = serviceTagDTO.convertItems(tags);
        return tagDTOS;
    }

    @Autowired
    private Cloudinary cloudinary;

    @RequestMapping("/image")
    public void image() {
        try {
            Map uploadResult = cloudinary.uploader().upload("C:\\Users\\Андрей\\Downloads\\Mario.jpg", com.cloudinary.utils.ObjectUtils.emptyMap());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/login")
    public void login() {

    }

    @RequestMapping(path = "manuals/bytag/{tagname}", method = RequestMethod.GET)
    public List<ManualDTO> getManualsByTag(@PathVariable String tagname) {
        return serviceManualDTO.convertItems(new ArrayList<>(tagService.findByName(tagname).getManuals()));
    }

    @Autowired
    private HibernateSearch hibernateSearch;

    @RequestMapping(path = "manuals/{keyword}")
    public List<ManualDTO> getManualsByKeyWord(@PathVariable String keyword) {
        List<ManualDTO> manuals = serviceManualDTO.convertItems(hibernateSearch.fulltextSearching(keyword));
        return manuals;
    }

    @RequestMapping(value = "/userprofile", method = RequestMethod.POST)
    public void updateUser(@RequestBody UserExtendedDTO userExtDTO) {
        userService.updateUser(serviceUserExtendedDTO.convertFromItemDTO(userExtDTO));
    }

    @RequestMapping(value = "/newinstruction", method = RequestMethod.POST)
    public Long newInstruction(@RequestBody ManualDTO manDTO) {
        Long id = manualService.saveManual(serviceManualDTO.convertFromItemDTO(manDTO));
        System.out.println(id);
        return id;
    }

    @Autowired
    RatingDTO ratingDTO;

    @Autowired
    RatingService ratingService;

    @RequestMapping(value = "/setRating", method = RequestMethod.POST)
    public void setRating(@RequestBody RatingDTO ratingDTO) {
        ratingService.saveRating(serviceRatingDTO.convertFromItemDTO(ratingDTO));
    }


    @RequestMapping(value = "/popularManuals")
    public List<ManualDTO> getPopularManuals() {
        return serviceManualDTO.getPopularManuals();
    }

}
