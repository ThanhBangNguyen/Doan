package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.Relax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RelaxRepository extends JpaRepository<Relax, Long> {

    @Query(value = "SELECT * FROM relax WHERE category_id = ?1 ", nativeQuery = true)
    List<Relax> listRelax(Long id);

    @Query(value = "SELECT * FROM relax WHERE id_relax = ?1 ", nativeQuery = true)
    Relax findRelax(Long id);
    @Query(value = "SELECT * FROM relax WHERE id_relax = ?1", nativeQuery = true)
    Relax detailRelax(Long id);
}
