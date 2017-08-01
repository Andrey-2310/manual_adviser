package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Manual;
import com.ranv.Model.ModelDB.Step;
import com.ranv.Repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ManualService {
    @Autowired
    private ManualRepository manualRepository;


    public List<Manual> findAll() {
        return manualRepository.findAll();
    }

    public Manual findOne(Long id) {
        return manualRepository.findOne(id);
    }

    public List<Manual> findPublished() {
        return manualRepository.findByPublished(true);
    }

    @Autowired
    private MedalService medalService;


    public Long saveManual(Manual manual) {
        if (manual.getUser().getManuals().size() == 0)
            medalService.setMedalToUser(manual.getUser().getId(), "First Manual");
        return manualRepository.save(manual).getId();
    }

    @Autowired
    private StepService stepService;


    public void updateManual(Manual manual) {
        manualRepository.save(manual);
        if(manual.getSteps()!=null) {
            for (Step step : manual.getSteps())
                stepService.updateStep(step);
        }
    }

    @Transactional
    public void deleteManual(Long manualId){
        stepService.deleteStepsByManualId(manualId);
        manualRepository.delete(manualId);
    }

}
