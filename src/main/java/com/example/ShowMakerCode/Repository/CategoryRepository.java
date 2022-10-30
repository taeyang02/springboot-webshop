package com.example.ShowMakerCode.Repository;

import com.example.ShowMakerCode.Entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "select o from Category o where o.id = ?1",nativeQuery = false)
    Category cFindById(Long Id);
}