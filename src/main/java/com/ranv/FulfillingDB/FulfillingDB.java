package com.ranv.FulfillingDB;

import com.ranv.Repository.ManualRepository;
import com.ranv.Repository.RoleRepository;
import com.ranv.Repository.TagRepository;
import com.ranv.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FulfillingDB {

    @Autowired
    private ManualRepository manualRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private Entities entities;

    public void fulfillDB() {
        // tagRepository.save(entities.getTags());
        userRepository.save(entities.getUsers());
        manualRepository.save(entities.getManuals());
        // roleRepository.save(entities.getRoles());
    }
}
