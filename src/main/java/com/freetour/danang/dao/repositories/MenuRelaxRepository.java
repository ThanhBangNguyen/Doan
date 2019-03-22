package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.MenuRelax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRelaxRepository extends JpaRepository<MenuRelax, Long> {


    @Query(value = "SELECT * FROM menu_relax as a " +
            "inner join relax as b " +
            "on a.id_relax = b.id_relax " +
            "WHERE a.id_relax = ?1 ", nativeQuery = true)
    List<MenuRelax> MenuRelax(Long id);

    @Query(value = "SELECT * FROM menu_relax WHERE id_menu_relax = ?1", nativeQuery = true)
    MenuRelax findMenuRelax(Long id);


}
