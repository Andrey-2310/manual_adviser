package com.ranv.controller;

import com.ranv.model.DTO.StepDTO;
import com.ranv.service.serviceDTO.ServiceStepDTO;
import com.ranv.service.serviceDTO.ServiceUnitDTO;
import com.ranv.service.serviceModel.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
public class StepController {

    private StepService stepService;
    private ServiceStepDTO serviceStepDTO;
    private ServiceUnitDTO serviceUnitDTO;

    @Autowired
    public StepController(StepService stepService, ServiceStepDTO serviceStepDTO,
                          ServiceUnitDTO serviceUnitDTO) {
        this.stepService = stepService;
        this.serviceStepDTO = serviceStepDTO;
        this.serviceUnitDTO=serviceUnitDTO;
    }

    @RequestMapping("/step/{id}")
    public StepDTO getStep(@PathVariable Long id) {
        StepDTO stepDTO = serviceStepDTO.convertToItemDTO(stepService.findById(id));
        stepDTO.setUnits(serviceUnitDTO.sortUnitsByOrder(new ArrayList<>(stepDTO.getUnits())));
        return stepDTO;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/updatestep", method = RequestMethod.POST)
    public void updateStep(@RequestBody StepDTO stepDTO) {
        stepService.updateStep(serviceStepDTO.convertFromItemDTO(stepDTO));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/addStep", method = RequestMethod.POST)
    public Long addStep(@RequestBody StepDTO stepDTO) {
        return stepService.saveStep(serviceStepDTO.convertFromItemDTO(stepDTO));
    }

    @RequestMapping("/deletestep/{id}")
    public void deleteStep(@PathVariable Long id) {
        stepService.deleteStep(id);
    }
}
