package com.example.ShowMakerCode.Service.EntiryService;

import com.example.ShowMakerCode.Entity.Product;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();

    List<Product> findAll(Sort sort);

    List<Product> findAllById(Iterable<Long> longs);

    <S extends Product> S saveAndFlush(S entity);

    <S extends Product> S save(S entity);

    Optional<Product> findById(Long aLong);

    long count();

    void deleteById(Long aLong);

    @Query("select  o from Product  o where o.available = 1")
    List<Product> GetAllActive();


    @Query(value = "select  o from  Product  o WHERE o.available=1", nativeQuery = false)
    List<Product> GetAllActiveSort(Sort sort);

    @Query(value = "select o from  Product  o WHERE o.available=1 ", nativeQuery = false)
    List<Product> GetAllActiveSort(PageRequest sort);

    @Query(value = "select  o from Product o WHERE o.id=?1", nativeQuery = false)
    Product findByIdProduct(Long id);

    @Query(value = "select o from  Product o where o.category.id=?1 and o.available = 1", nativeQuery = false)
    List<Product> findByCategory(Long id);


    @Query(value = "SELECT * FROM java5_asm.product  WHERE category_id = ?1 and id!=?2 and available=1 ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Product> getAllByRanDom(Long cateID, Long idProduct);

    @Query(value = "select o.product from OrderDetail o where o.order.id = ?1", nativeQuery = false)
    List<Product> FindProductByOrder(Long id);
}
