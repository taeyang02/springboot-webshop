package com.example.ShowMakerCode.Service.ServiceIplm;

import com.example.ShowMakerCode.Entity.Order;
import com.example.ShowMakerCode.Entity.OrderDetail;
import com.example.ShowMakerCode.Repository.OrderDetailRepository;
import com.example.ShowMakerCode.Service.EntiryService.OrderDetailService;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
@Service
public class OrderDetailServiceIplm implements OrderDetailService {
    OrderDetailRepository orderDetailRepository;

    public OrderDetailServiceIplm(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public List<OrderDetail> findAll(Sort sort) {
        return orderDetailRepository.findAll(sort);
    }

    @Override
    public List<OrderDetail> findAllById(Iterable<Long> longs) {
        return orderDetailRepository.findAllById(longs);
    }

    @Override
    public <S extends OrderDetail> S save(S entity) {
        return orderDetailRepository.save(entity);
    }

    @Override
    public Optional<OrderDetail> findById(Long aLong) {
        return orderDetailRepository.findById(aLong);
    }

    @Override
    public void deleteById(Long aLong) {
        orderDetailRepository.deleteById(aLong);
    }

    @Override
    public <S extends OrderDetail> Page<S> findAll(Example<S> example, Pageable pageable) {
        return orderDetailRepository.findAll(example, pageable);
    }

    @Override
    public <S extends OrderDetail, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return orderDetailRepository.findBy(example, queryFunction);


    }

    @Override
    @Query(value = "select o from OrderDetail o where o.order.id=?1", nativeQuery = false)
    public List<Order> getAllByOrder(Long id) {
        return orderDetailRepository.getAllByOrder(id);
    }

    @Override
    @Query(value = "Delete from OrderDetail o where o.order.id= ?1", nativeQuery = false)
    @Modifying
    public Void deleteOrderDetailByIdOrder(Long id) {
        return orderDetailRepository.deleteOrderDetailByIdOrder(id);
    }

    @Override
    @Query(value = "select o from OrderDetail  o where o.product.id = ?1 and o.size = ?2", nativeQuery = false)
    public OrderDetail findByProductIdAndProductSize(Long idProduct, String sizeProduct) {
        return orderDetailRepository.findByProductIdAndProductSize(idProduct, sizeProduct);
    }

    @Override
    @Query(value = "select o from OrderDetail o where o.order.id = ?1", nativeQuery = false)
    public List<OrderDetail> findOrderDetailByOrderId(Long IdOder) {
        return orderDetailRepository.findOrderDetailByOrderId(IdOder);
    }
}
