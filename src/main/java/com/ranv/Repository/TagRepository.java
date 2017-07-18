package com.ranv.Repository;

import com.ranv.Model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Андрей on 13.07.2017.
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
   Tag findByName(String name);
}
