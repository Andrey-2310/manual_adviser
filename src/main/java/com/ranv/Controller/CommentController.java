package com.ranv.Controller;

import com.ranv.Model.DTO.CommentDTO;
import com.ranv.Service.ServiceDTO.ServiceCommentDTO;
import com.ranv.Service.ServiceModel.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/commentsByStepId/{stepId}")
    public List<CommentDTO> getCommentsByStepId(@PathVariable Long stepId) {
        return serviceCommentDTO.convertItems(commentService.findCommentsByStepId(stepId));
    }

    @RequestMapping("/deleteCommentById/{id}")
    public void deleteCommentById(@PathVariable Long id) {
        commentService.deleteById(id);
    }

    @RequestMapping("/deleteCommentsByStepId/{stepId}")
    public void deleteCommentsByStepId(@PathVariable Long stepId){
        commentService.deleteByStepId(stepId);
    }
}
