package com.freetour.danang.dao.repositories;
import com.freetour.danang.dao.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, Long> {
}
