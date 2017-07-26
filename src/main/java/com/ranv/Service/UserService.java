package com.ranv.Service;

import com.ranv.Model.ModelDB.User;
import com.ranv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findOne(Long id) {
        return userRepository.findOne(id);
    }

    public User findById(Long id){ return  userRepository.findOne(id);}

    public void updateUser(User newUser){
        User oldUser =userRepository.findOne(newUser.getId());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setOrigin(newUser.getOrigin());
        oldUser.setImage(newUser.getImage());
        userRepository.save(oldUser);
    }
}
