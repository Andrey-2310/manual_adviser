package com.ranv.service.serviceModel;

import com.ranv.model.DB.Comment;
import com.ranv.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public void saveComment(Comment comment){
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        comment.setDate(sdf.format(dt));
        commentRepository.save(comment);}

    public List<Comment> findCommentsByStepId(Long stepId){
       return commentRepository.findAllByStepIdOrderByDateAsc(stepId);
    }

    public void deleteById(Long id){
        commentRepository.delete(id);
    }

    public void deleteByStepId(Long stepId){
        commentRepository.deleteByStepId(stepId);
    }

}
