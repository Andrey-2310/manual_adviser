package com.ranv.service.serviceModel;

import com.ranv.model.DB.User;
import com.ranv.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    public void updateUser(User user) {
        userRepository.updatingUser( user.getUsername(), user.getOrigin(),
                user.getImage(), user.getId());
    }

    public void saveUser(User user){userRepository.save(user);}

}
