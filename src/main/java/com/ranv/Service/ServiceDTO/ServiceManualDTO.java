package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.ManualDTO;
import com.ranv.Model.ModelDB.Manual;
import com.ranv.Service.ServiceModel.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.lang.Math.min;

@Service
public class ServiceManualDTO extends ServiceModelDTO<ManualDTO, Manual> {

    @Override
    public ManualDTO convertToItemDTO(Manual manual) {
        ManualDTO manualDTO = modelMapper.map(manual, ManualDTO.class);
        manualDTO.setUsername(manual.getUser().getUsername());
        manualDTO.setUserId(manual.getUser().getId());
        manualDTO.setRatingCustom(manual.getRatings());
        manualDTO.setTags(serviceTagDTO.convertItems(new ArrayList<>(manual.getTags())));
        manualDTO.setSteps(serviceStepDTO.convertItems(new ArrayList<>(manual.getSteps())));
        return manualDTO;
    }

    @Override
    public Manual convertFromItemDTO(ManualDTO manualDTO) {
        return modelMapper.map(manualDTO, Manual.class);
    }

    @Autowired
    ManualService manualService;

    @Autowired
    private ServiceTagDTO serviceTagDTO;

    @Autowired
    private ServiceStepDTO serviceStepDTO;

    public List<ManualDTO> getPopularManuals() {
        List<Manual> manuals = manualService.findAll();
        List<ManualDTO> manualDTOS = convertItems(manuals);
        manualDTOS.sort((a, b) -> a.getRating() > b.getRating() ? -1 :
                Objects.equals(a.getRating(), b.getRating()) ? 0 : 1);
        int sizeOfPopularList = 5;
        return manualDTOS.subList(0, min(manualDTOS.size(), sizeOfPopularList - 1));
    }

}
