package com.ranv.Controller;

import com.ranv.Model.DTO.ManualDTO;
import com.ranv.Model.ModelDB.Manual;
import com.ranv.Repository.FulltextSearch.HibernateSearch;
import com.ranv.Service.ServiceDTO.ServiceManualDTO;
import com.ranv.Service.ServiceModel.ManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ManualController {

    private final ServiceManualDTO serviceManualDTO;
    private final ManualService manualService;
    private final HibernateSearch hibernateSearch;

    @Autowired
    public ManualController(ServiceManualDTO serviceManualDTO, ManualService manualService, HibernateSearch hibernateSearch) {
        this.manualService = manualService;
        this.serviceManualDTO = serviceManualDTO;
        this.hibernateSearch = hibernateSearch;
    }


    @RequestMapping("/manual/{id}")
    public ManualDTO getManual(@PathVariable Long id) {
        Manual manual = manualService.findOne(id);
        return serviceManualDTO.convertToItemDTO(manual);
    }

    @RequestMapping(path = "manuals/bytag/{tagname}/{offset}", method = RequestMethod.GET)
    public List<ManualDTO> getManualsByTag(@PathVariable String tagname, @PathVariable int offset) {
        return serviceManualDTO.convertItems(
                new ArrayList<>(manualService.findNextManualsByTagname(tagname, offset)));
    }

    @RequestMapping(path = "manuals/byUserId/{userId}/{offset}", method = RequestMethod.GET)
    public List<ManualDTO> getManualsByUserId(@PathVariable Long userId, @PathVariable int offset) {
        return serviceManualDTO.convertItems(manualService.findNextManualsByUserId(userId, offset));
    }


    @RequestMapping(path = "manuals/{keyword}/{offset}")
    public List<ManualDTO> getManualsByKeyWord(
            @PathVariable String keyword, @PathVariable int offset) {
        List<ManualDTO> manuals = serviceManualDTO.convertItems(
                hibernateSearch.fulltextSearching(keyword, offset));
        return manuals;
    }

    @RequestMapping(value = "/popularManuals")
    public List<ManualDTO> getPopularManuals() {
        return serviceManualDTO.convertItems(manualService.findPopularManuals());
    }


    @RequestMapping("/deletemanual/{id}")
    public void deleteManual(@PathVariable Long id) {
        manualService.deleteManual(id);
    }


    @RequestMapping(value = "/newinstruction", method = RequestMethod.POST)
    public Long newInstruction(@RequestBody ManualDTO manDTO) {
        Long id = manualService.saveManual(serviceManualDTO.convertFromItemDTO(manDTO));
        System.out.println(id);
        return id;
    }

    @RequestMapping(value = "/updatemanual", method = RequestMethod.POST)
    public void updateManual(@RequestBody ManualDTO manualDTO) {
        manualService.updateManual(serviceManualDTO.convertFromItemDTO(manualDTO));
    }
}
