package com.ranv.Repository;

import com.ranv.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Андрей on 13.07.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
