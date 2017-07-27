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

import java.math.BigInteger;
import java.security.SecureRandom;
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
                new Manual("Butterfly, Animated.", sdf.format(dt), "How to make butterfly", userRepository.findOne(1L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("HandMade"), tagRepository.findByName("Beauty")}), "https://cdn.instructables.com/FL4/HRRT/J5CQBR9U/FL4HRRTJ5CQBR9U.MEDIUM.jpg"),
                new Manual("Wood Trailer", sdf.format(dt), "Every man should make three things in his life...", userRepository.findOne(2L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("HandMade")}), "https://cdn.instructables.com/FIT/P4Y6/J5CQ5XJM/FITP4Y6J5CQ5XJM.MEDIUM.jpg"),
                new Manual("Robotic Arm", sdf.format(dt), "Future is today", userRepository.findOne(1L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("Robot"), tagRepository.findByName("Technology")}), "https://cdn.instructables.com/FDC/4UJG/J5CQ56L7/FDC4UJGJ5CQ56L7.MEDIUM.jpg"),
                new Manual("Sound Locator", sdf.format(dt), "Pac-man  that runs towards the loudest sound detected!", userRepository.findOne(2L),
                        fromArrayToSet(new Tag[]{tagRepository.findByName("Micro")}), "https://cdn.instructables.com/F33/OOH2/I4IDDIPZ/F33OOH2I4IDDIPZ.MEDIUM.jpg")
        );
    }

    List<Manual> getRandomManual(int amount) {
        SecureRandom random = new SecureRandom();

        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Manual> manuals = new ArrayList<Manual>();
        for (int i = 0; i < amount; i++) {
            manuals.add(new Manual(
                    new BigInteger(60, random).toString(32),
                    sdf.format(dt),
                    new BigInteger(130, random).toString(32),
                    userRepository.findOne(random.nextInt(2)+1L),
                    fromArrayToSet(new Tag[]{tagRepository.findOne(random.nextInt(6)+1L)}),
                    "https://cdn.instructables.com/FIT/P4Y6/J5CQ5XJM/FITP4Y6J5CQ5XJM.MEDIUM.jpg"
            ));
        }
        return manuals;
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

    List<User> getUsers() {
        User[] users = new User[]{
                new User("Andrey", "https://vk.com/andreyredkovskiy", roleRepository.findOne(1L)),
                new User("Vlad", "https://vk.com/n__vlad", roleRepository.findOne(2L))
        };
        return Arrays.asList(users);
    }

    public List<Role> getRoles() {
        Role[] roles = new Role[]{
                new Role("Admin"),
                new Role("User")
        };
        return Arrays.asList(roles);
    }
}
