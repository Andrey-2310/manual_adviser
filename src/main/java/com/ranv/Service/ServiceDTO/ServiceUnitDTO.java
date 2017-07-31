package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.UnitDTO;
import com.ranv.Model.ModelDB.Unit;
import com.ranv.Service.ServiceModel.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUnitDTO extends ServiceModelDTO<UnitDTO, Unit> {
    @Override
    protected UnitDTO convertToItemDTO(Unit unit) {
        UnitDTO unitDTO = modelMapper.map(unit, UnitDTO.class);
        unitDTO.setStepId(unit.getStep().getId());
        return unitDTO;
    }

    @Autowired
    private StepService stepService;

    @Override
    public Unit convertFromItemDTO(UnitDTO unitDTO) {
        Unit unit = modelMapper.map(unitDTO, Unit.class);
        unit.setStep(stepService.findById(unitDTO.getStepId()));
        return unit;
    }
}