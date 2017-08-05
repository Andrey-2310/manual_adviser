package com.ranv.Repository;

import com.ranv.Model.ModelDB.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findBySub(String sub);
}
