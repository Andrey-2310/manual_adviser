package com.ranv.repository;

import com.ranv.model.DB.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalRepository extends JpaRepository<Medal, Long> {
    Medal findByName(String name);
}
