package com.ranv.Repository;

import com.ranv.Model.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {

}
