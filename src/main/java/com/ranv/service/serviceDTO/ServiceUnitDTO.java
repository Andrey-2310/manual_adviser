package com.ranv.service.serviceDTO;

import com.ranv.model.DTO.UnitDTO;
import com.ranv.model.DB.Unit;
import com.ranv.model.DB.UnitType;
import com.ranv.service.serviceModel.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class ServiceUnitDTO extends ServiceModelDTO<UnitDTO, Unit> {

    private final StepService stepService;

    @Autowired
    public ServiceUnitDTO(StepService stepService) {
        this.stepService = stepService;
    }

    @Override
    protected UnitDTO convertToItemDTO(Unit unit) {
        UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);
        unitDTO.setStepId(unit.getStep().getId());
        return unitDTO;
    }


    @Override
    public Unit convertFromItemDTO(UnitDTO unitDTO) {
        Unit unit = modelMapper.map(unitDTO, Unit.class);
        unit.setStep(stepService.findById(unitDTO.getStepId()));
        unit.setType(UnitType.valueOf(unitDTO.getType()));
        return unit;
    }

    public List<UnitDTO> sortUnitsByOrder(List<UnitDTO> units){
        units.sort(Comparator.comparingInt(UnitDTO::getOrder));
        return units;
    }
}
