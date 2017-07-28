package com.ranv.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.SortedMap;


@Getter
@Setter
@Component
public class TagDTO  {

    private String text;
    private Integer weight;



    public void setWeightCustom(Long usage, SortedMap<Long, Integer> usageToWeigh) {
        for (Map.Entry<Long, Integer> entry : usageToWeigh.entrySet()) {
            if (usage >= entry.getKey()) {
                setWeight(entry.getValue());
                break;
            }
        }
    }
}
