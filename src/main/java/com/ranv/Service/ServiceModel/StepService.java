package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Step;
import com.ranv.Model.ModelDB.Unit;
import com.ranv.Repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StepService {
    @Autowired
    StepRepository stepRepository;

    public Step findById(Long id) {
        return stepRepository.findOne(id);
    }

    public Long saveStep(Step step) {
        return stepRepository.save(step).getId();
    }

    @Autowired
    private UnitService unitService;

    public void updateStep(Step step) {
        stepRepository.save(step);
        for (Unit unit : step.getUnits())
            unitService.updateUnit(unit);
    }
}
