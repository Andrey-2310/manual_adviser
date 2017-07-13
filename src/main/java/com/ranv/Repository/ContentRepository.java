package com.ranv.Repository;

import com.ranv.Model.Content;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Андрей on 13.07.2017.
 */
public interface ContentRepository extends JpaRepository<Content, Long> {
}
