package com.ranv.service.serviceModel;

import com.ranv.model.DB.Manual;
import com.ranv.model.DB.Step;
import com.ranv.repository.ManualRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.lang.Math.min;


@Service
public class ManualService {

    private final ManualRepository manualRepository;


    @Autowired
    public ManualService(ManualRepository manualRepository) {
        this.manualRepository = manualRepository;
    }

    public List<com.ranv.model.DB.Manual> findAll() {
        return manualRepository.findAll();
    }

    public com.ranv.model.DB.Manual findOne(Long id) {
        return manualRepository.findOne(id);
    }

    @Autowired
    private MedalService medalService;


    public Long saveManual(Manual manual) {
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        manual.setDate(sdf.format(dt));
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


    public List<Manual> findPopularManuals() {
        return manualRepository.findTop10ByPublishedTrueOrderByRatingDesc();
    }


//    public List<Manual> findNextManualsById(Long id) {
//        return manualRepository.findTop10ByIdGreaterThanAndPublishedTrueOrderById(id);
//    }

    public List<Manual> findNextManualsByTagname(String tagname, int offset) {
        List<Manual> manuals = manualRepository.findByTagsNameAndPublishedTrueOrderByDate(tagname);
        return manuals.subList(offset, min(offset + 10, manuals.size()));
    }

    public List<Manual> findNextManualsByUserId(Long userId, int offset) {
        List<Manual> manuals = manualRepository.findByUserIdAndPublishedTrueOrderByDate(userId);
        return manuals.subList(offset, min(offset + 10, manuals.size()));
    }

    public List<Manual> findNextManualsByDate(Long id) {
        if (id != -1)
            return manualRepository.findTop10ByIdLessThanAndPublishedTrueOrderByIdDesc(id);
        return manualRepository.findTop10ByPublishedTrueOrderByIdDesc();
    }
}
