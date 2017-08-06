package com.ranv.controller;

import com.ranv.model.DTO.UnitDTO;
import com.ranv.service.serviceDTO.ServiceUnitDTO;

import com.ranv.service.serviceModel.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UnitController {

    private final com.ranv.service.serviceModel.UnitService unitService;
    private final ServiceUnitDTO serviceUnitDTO;

    @Autowired
       public UnitController(UnitService unitService, ServiceUnitDTO serviceUnitDTO){
        this.unitService=unitService;
        this.serviceUnitDTO=serviceUnitDTO;
    }

    @RequestMapping("/deleteunit/{id}")
    public void deleteUnit(@PathVariable Long id) {
        unitService.delete(id);
    }

    @RequestMapping(value = "/addUnit", method = RequestMethod.POST)
    public void addUnit(@RequestBody UnitDTO unitDTO) {
        unitService.saveUnit(serviceUnitDTO.convertFromItemDTO(unitDTO));
    }
}
