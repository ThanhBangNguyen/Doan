package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.Menu;
import com.freetour.danang.dao.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT * FROM menu as a " +
            "inner join restaurant as b " +
            "on a.restaurant_id = b.restaurant_id " +
            "WHERE b.restaurant_id = ?1 and a.featured=false ", nativeQuery = true)
    List<Menu> listById(Long id);
    @Query(value = "SELECT * FROM menu as a " +
            "inner join restaurant as b " +
            "on a.restaurant_id = b.restaurant_id " +
            "WHERE b.restaurant_id = ?1 and a.featured=true ", nativeQuery = true)
    Menu getFeatured(Long id);
    @Query(value = "SELECT * FROM menu as a " +
            "inner join restaurant as b " +
            "on a.restaurant_id = b.restaurant_id " +
            "WHERE b.restaurant_id = ?1 and a.type=1", nativeQuery = true)
    List<Menu> listByIdEAT(Long id);
    @Query(value = "SELECT * FROM menu as a " +
            "inner join restaurant as b " +
            "on a.restaurant_id = b.restaurant_id " +
            "WHERE b.restaurant_id = ?1 and a.type=2", nativeQuery = true)
    List<Menu> listByIdDrink(Long id);
    // admin
    @Query(value = "SELECT * FROM menu WHERE restaurant_id = ?1", nativeQuery = true)
    List<Menu> listMenu(Long id);

    @Query(value = "SELECT * FROM menu WHERE menu_id = ?1", nativeQuery = true)
    Menu findMenu(Long id);
    @Query(value = "SELECT * FROM menu WHERE menu_id = ?1", nativeQuery = true)
    Menu detailMenu(Long id);

}
