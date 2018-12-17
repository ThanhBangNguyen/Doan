package com.freetour.danang.dao.repositories;

import com.freetour.danang.dao.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    @Query(value = "SELECT * FROM category WHERE category_id = ?1", nativeQuery = true)
    Category findCategory(Long id);//ở đây  dùng Category để hứng dữ liệu

}
