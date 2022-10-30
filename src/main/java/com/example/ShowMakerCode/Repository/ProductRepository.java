package com.example.ShowMakerCode.Repository;

import com.example.ShowMakerCode.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select  o from Product  o where o.available = 1",nativeQuery = false)
    List<Product> GetAllActive();
    @Query(value = "select o from  Product  o WHERE o.available=1 ",nativeQuery = false)
    List<Product> GetAllActiveSort(Sort sort);
    @Query(value = "select o from  Product  o WHERE o.available=1 ",nativeQuery = false)
    List<Product> GetAllActiveSort(PageRequest sort);
    @Query(value = "select  o from Product o WHERE o.id=?1",nativeQuery = false)
    Product findByIdProduct(Long id);
    @Query(value = "select o from  Product o where o.category.id=?1 and o.available = 1",nativeQuery = false)
    List<Product> findByCategory(Long id);

    @Query(value = "SELECT * FROM java5_asm.product  WHERE category_id = ?1 and id!=?2 and available=1 ORDER BY RAND() LIMIT 5",nativeQuery = true)
    List<Product> getAllByRanDom(Long cateID,Long idProduct);

    @Query(value = "select o.product from OrderDetail o where o.order.id = ?1",nativeQuery = false)
    List<Product> FindProductByOrder(Long id);

}