package com.ranv.service.serviceDTO;

import com.ranv.model.DTO.TagDTO;
import com.ranv.model.DB.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SortedMap;

@Service
public class ServiceTagDTO extends ServiceModelDTO<TagDTO, Tag> {

    private final SortedMap<Long, Integer> usageToWeight;

    @Autowired
    public ServiceTagDTO(SortedMap<Long, Integer> usageToWeight) {
        this.usageToWeight = usageToWeight;
    }

    @Override
    protected TagDTO convertToItemDTO(Tag tag) {
        TagDTO tagDTO = new TagDTO();
        tagDTO.setId(tag.getId());
        tagDTO.setName(tag.getName());
        // Long weight = tag.getUsage();
        tagDTO.setWeightCustom((long) tag.getManuals().size(), usageToWeight);

        //tagDTO.setText();
        return tagDTO;
    }

    @Override
    public Tag convertFromItemDTO(TagDTO tagDTO) {
        return modelMapper.map(tagDTO, Tag.class);
    }
}
