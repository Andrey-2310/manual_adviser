package com.ranv.Service.ServiceModel;

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

    public void updateUser(User user){
        userRepository.save(user);
    }
}
