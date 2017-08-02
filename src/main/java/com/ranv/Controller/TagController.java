package com.ranv.Controller;

import com.ranv.Model.DTO.TagDTO;
import com.ranv.Model.ModelDB.Tag;
import com.ranv.Service.ServiceDTO.ServiceTagDTO;
import com.ranv.Service.ServiceModel.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TagController {

    private final TagService tagService;
    private final ServiceTagDTO serviceTagDTO;

    @Autowired
    public TagController(TagService tagService, ServiceTagDTO serviceTagDTO) {
        this.tagService = tagService;
        this.serviceTagDTO = serviceTagDTO;
    }


    @RequestMapping(value = "/addtag", method = RequestMethod.POST)
    public Long newInstruction(@RequestBody TagDTO tagDTO) {
        return tagService.saveAndGetId(serviceTagDTO.convertFromItemDTO(tagDTO));
    }

    @RequestMapping("/tags")
    public List<TagDTO> tags() {
        List<Tag> tags = tagService.findAll();
        List<TagDTO> tagDTOS = serviceTagDTO.convertItems(tags);
        return tagDTOS;
    }
}
