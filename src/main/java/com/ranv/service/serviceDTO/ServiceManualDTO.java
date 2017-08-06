package com.ranv.service.serviceDTO;

import com.ranv.model.DTO.ManualDTO;
import com.ranv.model.DB.Manual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceManualDTO extends ServiceModelDTO<ManualDTO, Manual> {

    private final ServiceTagDTO serviceTagDTO;
    private final ServiceStepDTO serviceStepDTO;

    @Autowired
    public ServiceManualDTO( ServiceTagDTO serviceTagDTO, ServiceStepDTO serviceStepDTO){
        this.serviceStepDTO=serviceStepDTO;
        this.serviceTagDTO=serviceTagDTO;
    }

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
