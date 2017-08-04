package com.ranv.Service.ServiceModel;

import com.ranv.Model.ModelDB.Comment;
import com.ranv.Repository.CommentRepository;
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

    public void saveComment(Comment comment){commentRepository.save(comment);}

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
