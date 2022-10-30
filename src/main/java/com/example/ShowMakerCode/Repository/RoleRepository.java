package com.example.ShowMakerCode.Repository;

import com.example.ShowMakerCode.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query(value = "select o from Role o where o.name = ?1",nativeQuery = false)
    Role findByNameRole(String UOA);
}