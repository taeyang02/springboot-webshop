package com.example.ShowMakerCode.Controller.OrderController;

import com.example.ShowMakerCode.Constant.SessionAttr;
import com.example.ShowMakerCode.Service.MyService.SessionService;
import com.example.ShowMakerCode.Entity.*;
import com.example.ShowMakerCode.Service.EntiryService.OrderDetailService;
import com.example.ShowMakerCode.Service.EntiryService.OrderService;
import com.example.ShowMakerCode.Service.EntiryService.ProductService;
import com.example.ShowMakerCode.Service.EntiryService.ShoppingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("smk/card")
public class OrderController {
    @Autowired
    OrderService orderService;
    @Autowired
    OrderDetailService orderDetailService;
    @Autowired
    ShoppingCardService shoppingCardService;
    @Autowired
    SessionService sessionService;
    @Autowired
    ProductService productService;
    @GetMapping("buy")
    public String Hello(){
        try {

        Collection<ShoppingCard> shoppingCards = shoppingCardService.getCardItems();
        Account account = sessionService.get(SessionAttr.CURRENT_USER);
        Order order = new Order();
        order.setAddress(account.getAddress());
        order.setPhoneNumber(account.getPhoneNumber());
        order.setCreateBy(account.getUsername());
        order.setCreateDate(new Date().toInstant());
        order.setStatus((byte) 0);
        Order orderCurrent = orderService.save(order);
        for (int i = 0; i < shoppingCards.size(); i++) {
            ShoppingCard shoppingCard = (ShoppingCard) shoppingCards.toArray()[i];
            Product product = productService.findByIdProduct(shoppingCard.getId());
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProduct(product);
            orderDetail.setOrder(orderCurrent);
            orderDetail.setQuantity(shoppingCard.getQuantity());
            orderDetail.setSize(shoppingCard.getSize());
            orderDetail.setPrice(BigDecimal.valueOf(Double.parseDouble(String.valueOf(shoppingCard.getPrice()))*shoppingCard.getQuantity()));
            //set so luong giam

            orderDetailService.save(orderDetail);
        }}catch (Exception e){
            e.printStackTrace();
        }
        sessionService.set(SessionAttr.notification,String.valueOf(orderService.CountByIdOrder()));
        return "redirect:/smk/card/clear";
    }



    @GetMapping("wait-application")
    public String getWaitApplication(Model model){
        List<Order> orderList = orderService.getAllByStatusFalse();
        model.addAttribute("orderList",orderList);
        return "site/shoppingcard/waitapplication";
    }

    @GetMapping("/wait-application/approve/{id}")
    public String getApprove(@PathVariable("id")Long id){
        Order order = orderService.findById(id).get();
        order.setStatus((byte) 1);
        Order orderSave = orderService.saveAndFlush(order);
        if (orderSave != null){
            List<OrderDetail> orderDetails = orderDetailService.findOrderDetailByOrderId(id);
            for (int i = 0; i < orderDetails.size(); i++) {
                OrderDetail orderDetail = orderDetails.get(i);
                Product product = productService.findByIdProduct(orderDetail.getProduct().getId());
                product.setQuantitySold(product.getQuantitySold() + orderDetail.getQuantity());
                product.setQuantity(product.getQuantity() - orderDetail.getQuantity());
                productService.saveAndFlush(product);
            }
        }
        sessionService.set(SessionAttr.notification,String.valueOf(orderService.CountByIdOrder()));
        return "redirect:/smk/card/wait-application";
    }

    @GetMapping("/wait-application/un-approve/{id}")
    public String getUnApprove(@PathVariable("id")Long id){
        try {
            orderDetailService.deleteOrderDetailByIdOrder(id);
        }catch (Exception e){
            System.out.println("Error");
        }
        try {
            orderService.deleteById(id);
            sessionService.set(SessionAttr.notification,String.valueOf(orderService.CountByIdOrder()));
        }catch (Exception e){
            System.out.println("Không tồn Tại Order");
        }
        return "redirect:/smk/card/wait-application";
    }

}
