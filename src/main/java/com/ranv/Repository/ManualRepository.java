package com.ranv.Repository;

import com.ranv.Model.Manual;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Андрей on 13.07.2017.
 */
@Repository
public interface ManualRepository extends JpaRepository<Manual, Long> {

}
