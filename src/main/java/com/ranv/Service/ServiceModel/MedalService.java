package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Medal;
import com.ranv.Model.ModelDB.User;
import com.ranv.Repository.MedalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedalService {


    private final MedalRepository medalRepository;
    private final UserService userService;

    @Autowired
    public MedalService(MedalRepository medalRepository, UserService userService) {
        this.medalRepository = medalRepository;
        this.userService = userService;
    }

    public Medal findById(Long id) {
        return medalRepository.findOne(id);
    }

    public Medal findByName(String name) {
        return medalRepository.findByName(name);
    }


    public void setMedalToUser(Long userId, String medalName) {
        User user = userService.findById(userId);
        Medal medal = findByName(medalName);
        user.getMedals().add(medal);
        userService.saveUser(user);
    }
}
