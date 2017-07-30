package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.ComparatorManualDTO.ManualDTOComparator;
import com.ranv.Model.DTO.ManualDTO;
import com.ranv.Model.ModelDB.Manual;
import com.ranv.Service.ServiceModel.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public List<ManualDTO> getPopularManuals() {
        List<Manual> manuals = manualService.findAll();
        List<ManualDTO> manualDTOS = convertItems(manuals);
        manualDTOS.sort(new ManualDTOComparator());
        int sizeOfPopularList = 5;
        return manualDTOS.subList(0, min(manualDTOS.size(), sizeOfPopularList - 1));
    }
}
