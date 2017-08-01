package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Step;
import com.ranv.Model.ModelDB.Unit;
import com.ranv.Repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StepService {
    @Autowired
    StepRepository stepRepository;

    public Step findById(Long id) {
        return stepRepository.findOne(id);
    }

    public List<Step> findStepsByManualId(Long id){
        return stepRepository.findByManualIdOrderByOrderAsc(id);
    }

    public Long saveStep(Step step) {
        return stepRepository.save(step).getId();
    }

    @Autowired
    private UnitService unitService;

    @Transactional
    public void deleteStep(Long stepId) {
        unitService.deleteUnitsByStepId(stepId);
        stepRepository.delete(stepId);
    }

    @Transactional
    public void deleteStepsByManualId(Long id){
        for(Step step: stepRepository.findByManualId(id)){
            unitService.deleteUnitsByStepId(step.getId());
        }
        stepRepository.deleteByManualId(id);
    }

    public void updateStep(Step step) {
        stepRepository.save(step);
        if (step.getUnits() == null) {
            return;
        }
        for (Unit unit : step.getUnits())
            unitService.updateUnit(unit);
    }

}
