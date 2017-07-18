package com.ranv.Repository;

import com.ranv.Model.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Андрей on 13.07.2017.
 */
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long> {
}
