package com.ranv.Repository;

import com.ranv.Model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Андрей on 13.07.2017.
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
