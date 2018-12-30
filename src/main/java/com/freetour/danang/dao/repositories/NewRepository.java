package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.Category;
import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.New;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NewRepository extends JpaRepository<New, Long> {

    @Query(value = "SELECT * FROM new WHERE new_id = 1", nativeQuery = true)
    New findNewsOne();
    @Query(value = "SELECT * FROM new WHERE new_id  = ?1", nativeQuery = true)
    New findNew(Long id);


}
