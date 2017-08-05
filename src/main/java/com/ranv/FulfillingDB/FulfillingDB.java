package com.ranv.FulfillingDB;

import com.ranv.Repository.*;
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
    private RatingRepository ratingRepository;

//    @Autowired
//    private Entities entities;

    public void fulfillDB() {
        // tagRepository.save(entities.getTags());
        //userRepository.save(entities.getUsers());
       // manualRepository.save(entities.getManuals());
//        manualRepository.save(entities.getRandomManual(40));
        // roleRepository.save(entities.getRoles());
        //ratingRepository.save(new Rating(userRepository.findOne(1L), manualRepository.findOne(1L), 1L));
    }
}
