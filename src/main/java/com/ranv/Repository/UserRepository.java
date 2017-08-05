package com.ranv.Repository;

import com.ranv.Model.ModelDB.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "update User user set user.name= :username"))
    void updateUser(@Param(value = "username") String username);


    User findByUsername(String username);

    User findBySub(String sub);


}
