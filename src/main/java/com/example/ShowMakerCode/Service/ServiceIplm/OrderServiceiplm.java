package com.example.ShowMakerCode.Service.ServiceIplm;

import com.example.ShowMakerCode.Entity.Order;
import com.example.ShowMakerCode.Repository.OrderRepository;
import com.example.ShowMakerCode.Service.EntiryService.OrderService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class OrderServiceiplm implements OrderService {
    OrderRepository orderRepository;

    public OrderServiceiplm(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return orderRepository.findAll(sort);
    }

    @Override
    public <S extends Order> S save(S entity) {
        return orderRepository.save(entity);
    }

    @Override
    public Optional<Order> findById(Long aLong) {
        return orderRepository.findById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        orderRepository.deleteById(aLong);
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return orderRepository.findBy(example, queryFunction);
    }

    @Override
    @Query("select o from Order o where o.status = 0")
    public List<Order> getAllByStatusFalse() {
        return orderRepository.getAllByStatusFalse();
    }

    @Override
    @Query(value = "select o from Order o where o.createBy like ?1", nativeQuery = false)
    public Order findByCreater(String username) {
        return orderRepository.findByCreater(username);
    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        return orderRepository.saveAndFlush(entity);
    }

    @Override
    @Query(value = "DELETE FROM Order o WHERE o.id=?1", nativeQuery = false)
    public Order deleteOrderDetailById(Long id) {
        return orderRepository.deleteOrderDetailById(id);
    }

    @Override
    @Query("select count(o.id)from Order o where o.status = 0")
    public Integer CountByIdOrder() {
        return orderRepository.CountByIdOrder();
    }
}
