package com.ranv.Repository;

import com.ranv.Model.ModelDB.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
}
