package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    // List ra các nhà hàng thức ăn với sự ưu tiên là 1
    @Query(value = "select * from restaurant where category_id=1 and type=1", nativeQuery = true)
    List<Restaurant> findEat();
    // List ra các nhà hàng thức uống với sự ưu tiên là 1
    @Query(value = "select * from restaurant where category_id=2 and type=1", nativeQuery = true)
    List<Restaurant> findDrink();
    // List ra các nhà hàng thức ăn với sự ưu tiên là 2
    @Query(value = "select * from restaurant where category_id=1 and type=2 or type=3", nativeQuery = true)
    List<Restaurant> findEatMenu();
    // List ra các nhà hàng thức uống với sự ưu tiên là 2
    @Query(value = "select * from restaurant where category_id=2 and type=2 or type=3", nativeQuery = true)
    List<Restaurant> findDrinkMenu();
    // Get ra nhà hàng theo id
    @Query(value = "SELECT * FROM restaurant WHERE restaurant_id = ?1", nativeQuery = true)
    Restaurant listById(Long id);
    // List Restaurant theo id trong admin
    @Query(value = "SELECT * FROM restaurant WHERE category_id = ?1", nativeQuery = true)
    List<Restaurant> listStore(Long id);
    // Detail store
    @Query(value = "SELECT * FROM restaurant WHERE restaurant_id = ?1", nativeQuery = true)
    Restaurant detailStore(Long id);
}
