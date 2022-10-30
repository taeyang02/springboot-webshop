package com.example.ShowMakerCode.Service.ServiceIplm;


import com.example.ShowMakerCode.Entity.Product;
import com.example.ShowMakerCode.Repository.ProductRepository;
import com.example.ShowMakerCode.Service.EntiryService.ProductService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceIplm implements ProductService {
    ProductRepository productRepository;

    public ProductServiceIplm(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findAll(Sort sort) {
        return productRepository.findAll(sort);
    }

    @Override
    public List<Product> findAllById(Iterable<Long> longs) {
        return productRepository.findAllById(longs);
    }

    @Override
    public <S extends Product> S saveAndFlush(S entity) {
        return productRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Product> S save(S entity) {
        return productRepository.save(entity);
    }

    @Override
    public Optional<Product> findById(Long aLong) {
        return productRepository.findById(aLong);
    }

    @Override
    public long count() {
        return productRepository.count();
    }

    @Override
    public void deleteById(Long aLong) {
        productRepository.deleteById(aLong);
    }

    @Override
    @Query("select  o from Product  o where o.available = 1")
    public List<Product> GetAllActive() {
        return productRepository.GetAllActive();
    }

    @Override
    @Query(value = "select  o from  Product  o WHERE o.available=1", nativeQuery = false)
    public List<Product> GetAllActiveSort(Sort sort) {
        return productRepository.GetAllActiveSort(sort);
    }

    @Override
    @Query(value = "select o from  Product  o WHERE o.available=1 ", nativeQuery = false)
    public List<Product> GetAllActiveSort(PageRequest sort) {
        return productRepository.GetAllActiveSort(sort);
    }

    @Override
    @Query(value = "select  o from Product o WHERE o.id=?1", nativeQuery = false)
    public Product findByIdProduct(Long id) {
        return productRepository.findByIdProduct(id);
    }

    @Override
    @Query(value = "select o from  Product o where o.category.id=?1 and o.available = 1", nativeQuery = false)
    public List<Product> findByCategory(Long id) {
        return productRepository.findByCategory(id);
    }

    @Override
    @Query(value = "SELECT * FROM java5_asm.product  WHERE category_id = ?1 and id!=?2 and available=1 ORDER BY RAND() LIMIT 5", nativeQuery = true)
    public List<Product> getAllByRanDom(Long cateID, Long idProduct) {
        return productRepository.getAllByRanDom(cateID, idProduct);
    }

    @Override
    @Query(value = "select o.product from OrderDetail o where o.order.id = ?1", nativeQuery = false)
    public List<Product> FindProductByOrder(Long id) {
        return productRepository.FindProductByOrder(id);
    }
}
