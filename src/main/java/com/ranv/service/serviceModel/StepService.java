package com.ranv.service.serviceModel;

import com.ranv.model.DB.Step;
import com.ranv.model.DB.Unit;
import com.ranv.repository.StepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StepService {

    private final StepRepository stepRepository;
    private final UnitService unitService;
    private final CommentService commentService;

    @Autowired
    public StepService(StepRepository stepRepository, UnitService unitService, CommentService commentService) {
        this.stepRepository = stepRepository;
        this.unitService = unitService;
        this.commentService = commentService;
    }

    public Step findById(Long id) {
        return stepRepository.findOne(id);
    }

    public List<Step> findStepsByManualId(Long id) {
        return stepRepository.findByManualIdOrderByOrderAsc(id);
    }

    public Long saveStep(Step step) {
        return stepRepository.save(step).getId();
    }

    @Transactional
    public void deleteStep(Long stepId) {
        unitService.deleteUnitsByStepId(stepId);
        commentService.deleteByStepId(stepId);
        stepRepository.delete(stepId);
    }

    @Transactional
    void deleteStepsByManualId(Long id) {
        for (Step step : stepRepository.findByManualId(id)) {
            unitService.deleteUnitsByStepId(step.getId());
            commentService.deleteByStepId(step.getId());
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
