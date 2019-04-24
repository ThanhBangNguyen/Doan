package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.New;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public interface NewRepository extends JpaRepository<New, Long> {

    @Query(value = "SELECT * FROM new WHERE new_id = 1", nativeQuery = true)
    New findNewsOne();
    @Query(value = "SELECT * FROM new WHERE new_id  = ?1", nativeQuery = true)
    New findNew(Long id);


}
