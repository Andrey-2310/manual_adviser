package com.ranv.service.serviceDTO;

import com.ranv.model.DTO.CommentDTO;
import com.ranv.model.DB.Comment;
import com.ranv.service.serviceModel.StepService;
import com.ranv.service.serviceModel.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceCommentDTO extends ServiceModelDTO<CommentDTO, Comment> {

    private final UserService userService;
    private final StepService stepService;

    @Autowired
    public ServiceCommentDTO(UserService userService, StepService stepService) {
        this.userService = userService;
        this.stepService = stepService;
    }

    @Override
    public CommentDTO convertToItemDTO(Comment comment) {
        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
        commentDTO.setStepId(comment.getStep().getId());
        commentDTO.setUsername(comment.getUser().getUsername());
        commentDTO.setUserImage(comment.getUser().getImage());
        commentDTO.setUserId(comment.getUser().getId());
        return commentDTO;
    }

    @Override
    public Comment convertFromItemDTO(CommentDTO commentDTO) {
        Comment comment = modelMapper.map(commentDTO, Comment.class);
        comment.setStep(stepService.findById(commentDTO.getStepId()));
        comment.setUser(userService.findById(commentDTO.getUserId()));
        return comment;
    }
}
