package com.ranv.controller;

import com.ranv.model.DTO.UnitDTO;
import com.ranv.service.serviceDTO.ServiceUnitDTO;

import com.ranv.service.serviceModel.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping("/deleteunit/{id}")
    public void deleteUnit(@PathVariable Long id) {
        unitService.delete(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/addUnit", method = RequestMethod.POST)
    public Long addUnit(@RequestBody UnitDTO unitDTO) {
        return unitService.saveUnit(serviceUnitDTO.convertFromItemDTO(unitDTO));
    }
}
