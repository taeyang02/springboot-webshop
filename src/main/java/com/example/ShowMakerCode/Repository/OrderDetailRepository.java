package com.example.ShowMakerCode.Repository;

import com.example.ShowMakerCode.Entity.Order;
import com.example.ShowMakerCode.Entity.OrderDetail;
import com.example.ShowMakerCode.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    @Query(value = "select o from OrderDetail o where o.order.id=?1",nativeQuery = false)
    List<Order> getAllByOrder(Long id);
    @Modifying
    @Query(value = "Delete from OrderDetail o where o.order.id= ?1",nativeQuery = false)
    Void deleteOrderDetailByIdOrder(Long id);
    @Query(value = "select o from OrderDetail  o where o.product.id = ?1 and o.size = ?2",nativeQuery = false)
    OrderDetail findByProductIdAndProductSize(Long idProduct,String sizeProduct);

    @Query(value = "select o from OrderDetail o where o.order.id = ?1",nativeQuery = false)
    List<OrderDetail> findOrderDetailByOrderId(Long IdOder);
}