package com.ranv.Repository;

import com.ranv.Model.ModelDB.Medal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedalRepository extends JpaRepository<Medal, Long> {
}
