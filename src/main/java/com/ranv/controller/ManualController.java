package com.ranv.controller;

import com.ranv.configuration.achievements.events.CreateManualEvent;
import com.ranv.model.DTO.ManualDTO;
import com.ranv.model.DB.Manual;
import com.ranv.repository.fulltextSearch.HibernateSearch;
import com.ranv.service.eventsPublishing.Publisher;
import com.ranv.service.serviceDTO.ServiceManualDTO;
import com.ranv.service.serviceModel.ManualService;
import com.ranv.service.serviceModel.StepService;
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
    private final Publisher publisher;
    private final StepService stepService;

    @Autowired
    public ManualController(ServiceManualDTO serviceManualDTO, ManualService manualService,
                            HibernateSearch hibernateSearch, StepService stepService, Publisher publisher) {
        this.manualService = manualService;
        this.serviceManualDTO = serviceManualDTO;
        this.hibernateSearch = hibernateSearch;
        this.stepService = stepService;
        this.publisher = publisher;
    }


    @RequestMapping("/manual/{id}")
    public ManualDTO getManual(@PathVariable Long id) {
        Manual manual = manualService.findOne(id);
        manual.setSteps(stepService.findStepsByManualId(id));
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

    @RequestMapping(path="manuals/new/{id}")
    public List<ManualDTO> getNewManuals(@PathVariable Long id) {
        return serviceManualDTO.convertItems(manualService.findNextManualsByDate(id));
    }

    @RequestMapping(value = "/popularManuals")
    public List<ManualDTO> getPopularManuals() {
        return serviceManualDTO.convertItems(manualService.findPopularManuals());
    }

    @RequestMapping(value = "/newManuals/{id}")
    public List<ManualDTO> getPopularManuals(@PathVariable Long id) {
        return serviceManualDTO.convertItems(manualService.findNextManualsByDate(id));
    }

    @RequestMapping("/deletemanual/{id}")
    public void deleteManual(@PathVariable Long id) {
        manualService.deleteManual(id);
    }


    @RequestMapping(value = "/newinstruction", method = RequestMethod.POST)
    public Long newInstruction(@RequestBody ManualDTO manDTO) {
        Long id = manualService.saveManual(serviceManualDTO.convertFromItemDTO(manDTO));
        publisher.publish(new CreateManualEvent(this, manDTO.getUserId()));
        return id;
    }

    @RequestMapping(value = "/updatemanual", method = RequestMethod.POST)
    public void updateManual(@RequestBody ManualDTO manualDTO) {
        manualService.updateManual(serviceManualDTO.convertFromItemDTO(manualDTO));
    }
}
