package com.ranv.controller;

import com.ranv.model.DTO.TagDTO;
import com.ranv.model.DB.Tag;
import com.ranv.service.serviceDTO.ServiceTagDTO;
import com.ranv.service.serviceModel.TagService;
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
