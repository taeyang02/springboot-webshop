package com.example.ShowMakerCode.Service.EntiryService;

import com.example.ShowMakerCode.Entity.Order;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface OrderService {
    List<Order> findAll();

    List<Order> findAll(Sort sort);

    <S extends Order> S save(S entity);

    Optional<Order> findById(Long aLong);

    void deleteById(Long aLong);

    <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);


    @Query("select o from Order o where o.status = 0")
    List<Order> getAllByStatusFalse();

    @Query(value = "select o from Order o where o.createBy like ?1", nativeQuery = false)
    Order findByCreater(String username);

    <S extends Order> S saveAndFlush(S entity);


    @Query(value = "DELETE FROM Order o WHERE o.id=?1", nativeQuery = false)
    Order deleteOrderDetailById(Long id);

    @Query("select count(o.id)from Order o where o.status = 0")
    Integer CountByIdOrder();
}
