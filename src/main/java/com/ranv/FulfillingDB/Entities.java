package com.ranv.FulfillingDB;

import com.ranv.Model.ModelDB.Manual;
import com.ranv.Model.ModelDB.Role;
import com.ranv.Model.ModelDB.Tag;
import com.ranv.Model.ModelDB.User;
import com.ranv.Repository.RoleRepository;
import com.ranv.Repository.TagRepository;
import com.ranv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class Entities {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private RoleRepository roleRepository;

    List<Manual> getManuals() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Arrays.asList(
                new Manual("Butterfly, Animated.",sdf.format(dt) , "How to make butterfly", userRepository.findOne(1L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("HandMade"), tagRepository.findByName("Beaty")})),
                new Manual("Wood Trailer", sdf.format(dt), "Every man should make three things in his life...", userRepository.findOne(2L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("HandMade")})),
                new Manual("Robotic Arm",sdf.format(dt) , "Future is today", userRepository.findOne(1L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("Robot"), tagRepository.findByName("Technology")})),
                new Manual("Arduino car", sdf.format(dt), "huy dogonish", userRepository.findOne(2L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("Arduino")}))
        );
    }

    public List<Tag> getTags() {
        Tag[] allTags = new Tag[]{new Tag("Havka"), new Tag("SosuZaEdu"), new Tag("Arduino")};
        return Arrays.asList(allTags);
    }

    private Set<Tag> fromArrayToSet(Tag[] tags) {
        Set<Tag> tagSet = new HashSet<>();
        Collections.addAll(tagSet, tags);
        return tagSet;
    }

    List<User> getUsers(){
        User[] users=new User[]{
                new User("Andrey", "https://vk.com/andreyredkovskiy", roleRepository.findOne(1L)),
                new User("Vlad", "https://vk.com/n__vlad", roleRepository.findOne(2L))
        };
        return Arrays.asList(users);
    }

    public List<Role> getRoles(){
        Role[] roles=new Role[]{
                new Role("Admin"),
                new Role("User")
        };
        return Arrays.asList(roles);
    }
}
