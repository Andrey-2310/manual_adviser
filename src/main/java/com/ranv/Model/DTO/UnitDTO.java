package com.ranv.Model.DTO;

import com.ranv.Model.ModelDB.UnitType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
public class UnitDTO {
    private Long id;
    private Long stepId;
    private int order;
    private UnitType unitType;
    private String content;

//    public UnitDTO( Long stepId, int order, UnitType unitType, String content) {
//        this.stepId = stepId;
//        this.order = order;
//        this.unitType = unitType;
//        this.content = content;
//    }
}
