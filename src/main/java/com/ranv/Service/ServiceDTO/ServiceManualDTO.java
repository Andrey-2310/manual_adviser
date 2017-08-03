package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.ManualDTO;
import com.ranv.Model.ModelDB.Manual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServiceManualDTO extends ServiceModelDTO<ManualDTO, Manual> {


    @Autowired
    private ServiceTagDTO serviceTagDTO;

    @Autowired
    private ServiceStepDTO serviceStepDTO;


    @Override
    public ManualDTO convertToItemDTO(Manual manual) {
        ManualDTO manualDTO = modelMapper.map(manual, ManualDTO.class);
        manualDTO.setUsername(manual.getUser().getUsername());
        manualDTO.setUserId(manual.getUser().getId());
        manualDTO.setTags(serviceTagDTO.convertItems(manual.getTags()));
        manualDTO.setSteps(serviceStepDTO.convertItems((manual.getSteps())));
        return manualDTO;
    }

    @Override
    public Manual convertFromItemDTO(ManualDTO manualDTO) {
        return modelMapper.map(manualDTO, Manual.class);
    }






}
