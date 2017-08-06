package com.ranv.repository;

import com.ranv.model.DB.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Transactional
    @Modifying
    @Query("update com.ranv.model.DB.User user set  user.username = ?1, user.origin = ?2," +
            "user.image= ?3 where user.id = ?4")
    void updatingUser( String username, String origin, String image,  Long id);


    User findByUsername(String username);

    User findBySub(String sub);


}
