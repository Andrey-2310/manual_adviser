package com.ranv.Controller;

import com.ranv.Model.DTO.UnitDTO;
import com.ranv.Service.ServiceDTO.ServiceUnitDTO;
import com.ranv.Service.ServiceModel.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class UnitController {

    private final UnitService unitService;
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
