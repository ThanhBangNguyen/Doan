package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select * from users where username=?1 and password=?2  "
            +"and "+"(role_id =1 or role_id=2)"  , nativeQuery = true)
    User adminLogin(String userName, String password);
    @Query(value = "select * from users where username=?1 and password=?2 and role_id=1", nativeQuery = true)
    User bossLogin(String userName, String password);
    @Query(value = "select * from users where role_id = 2 or role_id = 3 " , nativeQuery = true)
    List<User> findUser();
}
