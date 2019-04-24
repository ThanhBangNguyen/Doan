package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    @Query(value = "SELECT * FROM menu as a " +
            "inner join restaurant as b " +
            "on a.restaurant_id = b.restaurant_id " +
            "WHERE b.restaurant_id = ?1 and a.featured=false ", nativeQuery = true)
    List<Menu> listMenuById(Long id);
    @Query(value = "SELECT * FROM menu as a " +
            "inner join restaurant as b " +
            "on a.restaurant_id = b.restaurant_id " +
            "WHERE b.restaurant_id = ?1 and a.featured=true ", nativeQuery = true)
    Menu getFeatured(Long id);
    @Query(value = "SELECT * FROM menu as a " +
            "inner join restaurant as b " +
            "on a.restaurant_id = b.restaurant_id " +
            "WHERE b.restaurant_id = ?1 and a.type=1", nativeQuery = true)
    List<Menu> listByIdEat(Long id);
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
