package com.ranv.controller;

import com.ranv.model.DTO.CommentDTO;
import com.ranv.service.serviceDTO.ServiceCommentDTO;
import com.ranv.service.serviceModel.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CommentController {

    private final CommentService commentService;
    private final ServiceCommentDTO serviceCommentDTO;

    @Autowired
    public CommentController(CommentService commentService, ServiceCommentDTO serviceCommentDTO) {
        this.commentService = commentService;
        this.serviceCommentDTO = serviceCommentDTO;
    }

    @RequestMapping("/getCommentsByStepId/{stepId}")
    public List<CommentDTO> getCommentsByStepId(@PathVariable Long stepId) {
        return serviceCommentDTO.convertItems(commentService.findCommentsByStepId(stepId));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value= "/saveComment", method = RequestMethod.POST)
    public void saveComment(@RequestBody CommentDTO commentDTO) {
        commentService.saveComment(serviceCommentDTO.convertFromItemDTO(commentDTO));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value = "/deleteCommentById", method = RequestMethod.POST)
    public void deleteCommentById(@RequestBody Long id) {
        commentService.deleteById(id);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    @RequestMapping(value="/deleteCommentsByStepId", method = RequestMethod.POST)
    public void deleteCommentsByStepId(@RequestBody Long stepId) {
        commentService.deleteByStepId(stepId);
    }
}
