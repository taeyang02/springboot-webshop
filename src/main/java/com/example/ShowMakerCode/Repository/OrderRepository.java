package com.example.ShowMakerCode.Repository;

import com.example.ShowMakerCode.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query(value = "select o from Order o where o.createBy like ?1",nativeQuery = false)
    Order findByCreater(String username);

    @Query(value = "select o from Order o where o.status = 0")
    List<Order> getAllByStatusFalse();

    @Query(value = "DELETE FROM Order o WHERE o.id=?1",nativeQuery = false)
    Order deleteOrderDetailById(Long id);

    @Query(value = "select count(o.id)from Order o where o.status = 0")
    Integer CountByIdOrder();
}