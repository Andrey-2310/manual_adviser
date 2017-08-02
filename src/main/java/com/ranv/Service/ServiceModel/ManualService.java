package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Manual;
import com.ranv.Model.ModelDB.Step;
import com.ranv.Repository.ManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Math.min;


@Service
public class ManualService {

    private final ManualRepository manualRepository;


    @Autowired
    public ManualService(ManualRepository manualRepository){
        this.manualRepository=manualRepository;
    }

    public List<Manual> findAll() {
        return manualRepository.findAll();
    }

    public Manual findOne(Long id) {
        return manualRepository.findOne(id);
    }

    @Autowired
    private MedalService medalService;


    public Long saveManual(Manual manual) {
//        if (manual.getUser().getManuals().size() == 0)
//            medalService.setMedalToUser(manual.getUser().getId(), "First Manual");
        return manualRepository.save(manual).getId();
    }

    @Autowired
    private StepService stepService;


    public void updateManual(Manual manual) {
        manualRepository.save(manual);
        if (manual.getSteps() != null) {
            for (Step step : manual.getSteps())
                stepService.updateStep(step);
        }
    }

    @Transactional
    public void deleteManual(Long manualId) {
        stepService.deleteStepsByManualId(manualId);
        manualRepository.delete(manualId);
    }



    public List<Manual> findPopularManuals(){
       return manualRepository.findTop5ByPublishedTrueOrderByRatingDesc();
    }


//    public List<Manual> findNextManualsById(Long id) {
//        return manualRepository.findTop10ByIdGreaterThanAndPublishedTrueOrderById(id);
//    }

    public List<Manual> findNextManualsByTagname(String tagname, int offset) {
        List<Manual> manuals = manualRepository.findByTagsNameAndPublishedTrueOrderByDate(tagname);
        return manuals.subList(offset, min(offset+10, manuals.size()));
    }

    public List<Manual> findNextManualsByUserId(Long userId, int offset){
        List<Manual> manuals = manualRepository.findByUserIdAndPublishedTrueOrderByDate(userId);
        return manuals.subList(offset, min(offset+10, manuals.size()));
    }


}
