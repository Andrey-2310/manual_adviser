package com.ranv.Model.DTO;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class StepDTO {
    //TODO: add comments
    private Long id;
    private Long manualId;
    private List<UnitDTO> unitDTOS;


}
