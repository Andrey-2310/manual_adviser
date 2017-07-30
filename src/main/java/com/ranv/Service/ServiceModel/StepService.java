package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Step;
import com.ranv.Repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService {
    @Autowired
    StepRepository stepRepository;

    public Step findById(Long id){return stepRepository.findOne(id);}
    public void save(Step step){ stepRepository.save(step);}
}
