package com.ranv.Service.ServiceDTO;

import com.ranv.Model.DTO.CommentDTO;
import com.ranv.Model.ModelDB.Comment;
import org.springframework.stereotype.Service;

@Service
public class ServiceCommentDTO extends ServiceModelDTO<CommentDTO, Comment> {

    @Override
    public CommentDTO convertToItemDTO(Comment comment) {
        CommentDTO commentDTO= modelMapper.map(comment, CommentDTO.class);
        commentDTO.setStepId(comment.getStep().getId());
        commentDTO.setUsername(comment.getUser().getUsername());
        return commentDTO;
    }

    @Override
    public Comment convertFromItemDTO(CommentDTO itemDTO) {
        return null;
    }
}
