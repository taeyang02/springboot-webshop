package com.example.ShowMakerCode.Controller.DetailController;

import com.example.ShowMakerCode.Service.MyService.SessionService;
import com.example.ShowMakerCode.Entity.Product;
import com.example.ShowMakerCode.Service.EntiryService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("smk")
public class DetailController {
    @Autowired
    ProductService productService;
    @Autowired
    SessionService sessionService;
    @Autowired
    HttpServletRequest request;
@GetMapping("homepage/detail-product/{id}")
    public String homepage(@PathVariable("id")Long idProduct, Model model){
        sessionService.set("urlMainText",request.getRequestURI()); //set url de khi add co the back lai url
        Product product = productService.findByIdProduct(idProduct);
        List<Product> productList = productService.getAllByRanDom(product.getCategory().getId(),product.getId());
        System.out.println(productList);
        //size la 1 mang
        List<String> listSizeOfProduct = List.of(product.getSize().split(","));
        model.addAttribute("productList",productList);
        model.addAttribute("listSize",listSizeOfProduct);
        model.addAttribute("product",product);

    return "site/detailProduct/home";
}
}
