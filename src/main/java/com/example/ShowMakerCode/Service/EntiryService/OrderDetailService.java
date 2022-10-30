package com.example.ShowMakerCode.Service.EntiryService;

import com.example.ShowMakerCode.Entity.Order;
import com.example.ShowMakerCode.Entity.OrderDetail;
import com.example.ShowMakerCode.Entity.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface OrderDetailService {
    List<OrderDetail> findAll();

    List<OrderDetail> findAll(Sort sort);

    List<OrderDetail> findAllById(Iterable<Long> longs);

    <S extends OrderDetail> S save(S entity);

    Optional<OrderDetail> findById(Long aLong);

    void deleteById(Long aLong);

    <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends OrderDetail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

    @Query(value = "select o from OrderDetail o where o.order.id=?1", nativeQuery = false)
    List<Order> getAllByOrder(Long id);


    @Query(value = "Delete from OrderDetail o where o.order.id= ?1", nativeQuery = false)
    @Modifying
    Void deleteOrderDetailByIdOrder(Long id);


    @Query(value = "select o from OrderDetail  o where o.product.id = ?1 and o.size = ?2", nativeQuery = false)
    OrderDetail findByProductIdAndProductSize(Long idProduct, String sizeProduct);


    @Query(value = "select o from OrderDetail o where o.order.id = ?1", nativeQuery = false)
    List<OrderDetail> findOrderDetailByOrderId(Long IdOder);
}
