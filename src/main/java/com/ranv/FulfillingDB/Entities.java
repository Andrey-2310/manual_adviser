package com.ranv.FulfillingDB;

import com.ranv.Model.Manual;
import com.ranv.Model.Role;
import com.ranv.Model.Tag;
import com.ranv.Model.User;
import com.ranv.Repository.RoleRepository;
import com.ranv.Repository.TagRepository;
import com.ranv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Андрей on 16.07.2017.
 */
@Component
public class Entities {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private RoleRepository roleRepository;

    public List<Manual> getManuals() {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return Arrays.asList(
                new Manual("I love food",sdf.format(dt) , "Blya scha obojrys' kak suka", userRepository.findOne(1L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("Havka"), tagRepository.findByName("SosuZaEdu")})),
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
        for (Tag tag : tags) {
            tagSet.add(tag);
        }
        return tagSet;
    }

    public List<User> getUsers(){
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
