package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.StepDTO;
import com.ranv.Model.ModelDB.Step;
import com.ranv.Service.ServiceModel.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class ServiceStepDTO extends ServiceModelDTO<StepDTO, Step> {

    @Autowired
    ServiceUnitDTO serviceUnitDTO;

    @Override
    public StepDTO convertToItemDTO(Step step) {
        StepDTO stepDTO = modelMapper.map(step, StepDTO.class);
        stepDTO.setManualId(step.getManual().getId());
        stepDTO.setUnits(serviceUnitDTO.convertItems(step.getUnits()));
        return stepDTO;
    }

    @Autowired
    ManualService manualService;

    public Step convertFromItemDTO(StepDTO stepDTO){
        Step step= modelMapper.map(stepDTO, Step.class);
        step.setUnits(stepDTO.getUnits()!=null ? (serviceUnitDTO.convertItemsList(stepDTO.getUnits())) : Collections.emptyList());
        step.setManual(manualService.findOne(stepDTO.getManualId()));
        //TODO: add comments to step
        return step;
    }

    public List<StepDTO> sortStepsByOrder(List<StepDTO> steps){
        steps.sort((a, b) -> a.getOrder() > b.getOrder() ?
                -1 : a.getOrder() == b.getOrder() ? 0 : 1);
        return steps;
    }

}
