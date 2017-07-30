package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.TagDTO;
import com.ranv.Model.ModelDB.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.SortedMap;

@Service
public class ServiceTagDTO extends ServiceModelDTO<TagDTO, Tag> {

    @Autowired
    private SortedMap<Long, Integer> usageToWeight;

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
