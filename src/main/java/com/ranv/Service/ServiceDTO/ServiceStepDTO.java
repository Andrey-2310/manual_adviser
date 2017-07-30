package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.StepDTO;
import com.ranv.Model.ModelDB.Step;
import com.ranv.Service.ServiceModel.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
public class ServiceStepDTO extends ServiceModelDTO<StepDTO, Step> {

    @Override
    protected StepDTO convertToItemDTO(Step step) {
        StepDTO stepDTO = modelMapper.map(step, StepDTO.class);
        stepDTO.setManualId(step.getManual().getId());
        stepDTO.setUnits(serviceUnitDTO.convertItems(new ArrayList<>(step.getUnits())));
        return stepDTO;
    }
    @Autowired
    ServiceUnitDTO serviceUnitDTO;
    @Autowired
    ManualService manualService;

    public Step convertFromItemDTO(StepDTO stepDTO){
        Step step= modelMapper.map(stepDTO, Step.class);
        step.setUnits(new HashSet<>(serviceUnitDTO.convertItemsList(stepDTO.getUnits())));
        step.setManual(manualService.findOne(stepDTO.getManualId()));
        //TODO: add comments to step
        return step;
    }
}
