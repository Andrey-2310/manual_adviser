package com.ranv.Repository;

import com.ranv.Model.ModelDB.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByStepIdOrderByDateAsc(Long stepId);

    @Transactional
    void deleteByStepId(Long id);
}
