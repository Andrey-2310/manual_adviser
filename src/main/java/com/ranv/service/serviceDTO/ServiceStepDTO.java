package com.ranv.service.serviceDTO;

import com.ranv.model.DTO.StepDTO;
import com.ranv.model.DB.Step;
import com.ranv.service.serviceModel.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ServiceStepDTO extends ServiceModelDTO<StepDTO, Step> {

    private final ServiceUnitDTO serviceUnitDTO;
    private final ManualService manualService;

    @Autowired
    public ServiceStepDTO(ServiceUnitDTO serviceUnitDTO, ManualService manualService) {
        this.serviceUnitDTO = serviceUnitDTO;
        this.manualService = manualService;
    }

    @Override
    public StepDTO convertToItemDTO(Step step) {
        StepDTO stepDTO = modelMapper.map(step, StepDTO.class);
        stepDTO.setManualId(step.getManual().getId());
        stepDTO.setUnits(serviceUnitDTO.convertItems(step.getUnits()));
        return stepDTO;
    }

    public Step convertFromItemDTO(StepDTO stepDTO) {
        Step step = modelMapper.map(stepDTO, Step.class);
        step.setUnits(stepDTO.getUnits() != null ? (serviceUnitDTO.convertItemsList(stepDTO.getUnits())) : Collections.emptyList());
        step.setManual(manualService.findOne(stepDTO.getManualId()));
        //TODO: add comments to step
        return step;
    }

    public List<StepDTO> sortStepsByOrder(List<StepDTO> steps) {
        steps.sort((a, b) -> a.getOrder() > b.getOrder() ?
                -1 : a.getOrder() == b.getOrder() ? 0 : 1);
        return steps;
    }

}
