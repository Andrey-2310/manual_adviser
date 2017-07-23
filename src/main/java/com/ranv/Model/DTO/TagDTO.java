package com.ranv.Model.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ranv.Model.ModelDB.Tag;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;


@Getter
@Setter
@Component
public class TagDTO extends ModelDTO<TagDTO, Tag> {

    private String text;
    private Integer weight;

    @Autowired
    @JsonIgnore
    private SortedMap<Long, Integer> usageToWeight;


    @Override
    protected TagDTO convertToItemDTO(Tag tag) {
        TagDTO tagDTO=new TagDTO();
        tagDTO.setText(tag.getName());
        // Long weight = tag.getUsage();
        setWeightCustom((long) tag.getManuals().size(), tagDTO);

        //tagDTO.setText();
        return tagDTO;
    }

    private void setWeightCustom(Long usage, TagDTO tagDTO) {
        for (Map.Entry<Long, Integer> entry : usageToWeight.entrySet()) {
            if (usage >= entry.getKey()) {
                tagDTO.setWeight(entry.getValue());
                break;
            }
        }
    }
}
