package com.ranv.Controller;

import com.ranv.Configuration.Achievements.Events.CreateManualEvent;
import com.ranv.Model.DTO.ManualDTO;
import com.ranv.Model.ModelDB.Manual;
import com.ranv.Repository.FulltextSearch.HibernateSearch;
import com.ranv.Service.EventsPublisher.Publisher;
import com.ranv.Service.ServiceDTO.ServiceManualDTO;
import com.ranv.Service.ServiceModel.ManualService;
import com.ranv.Service.ServiceModel.StepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

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
        publisher.publish(new CreateManualEvent(this, manDTO.getUserId()));
        return id;
    }

    @RequestMapping(value = "/updatemanual", method = RequestMethod.POST)
    public void updateManual(@RequestBody ManualDTO manualDTO) {
        manualService.updateManual(serviceManualDTO.convertFromItemDTO(manualDTO));
    }
}
