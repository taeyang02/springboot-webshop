package com.example.ShowMakerCode.Controller.ProductController;

import com.example.ShowMakerCode.Constant.SessionAttr;
import com.example.ShowMakerCode.Service.MyService.SessionService;
import com.example.ShowMakerCode.Service.MyService.UploadService;
import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Entity.Category;
import com.example.ShowMakerCode.Entity.Product;
import com.example.ShowMakerCode.Service.EntiryService.CategoryService;
import com.example.ShowMakerCode.Service.EntiryService.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("smk/admin/product")
public class ProductController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    ProductService productService;
    @Autowired
    UploadService uploadService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    SessionService sessionService;

    @GetMapping("list-product")
    public String homeList(Model model){
    List<Product> productList = productService.GetAllActive();
    model.addAttribute("productList",productList);
    return "admin/product/home";
    }

    @GetMapping("add-product")
    public String addHome(Model model){
        model.addAttribute("product",new Product());
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categorys",categoryList);
        return "admin/product/addproduct";
    }

    @PostMapping("add-product")
    public String postHome(@RequestParam("file")MultipartFile file,@ModelAttribute("product")Product product){
        Category category = categoryService.cFindById(Long.valueOf(request.getParameter("categoryId")));
        product.setCategory(category);
        Account account = sessionService.get(SessionAttr.CURRENT_USER);
        product.setCreateBy(account.getUsername());
        product.setCreateDate(new Date().toInstant());
        product.setImage(uploadService.posst(file));
        product.setQuantitySold(0);
        product.setAvailable((byte) 1);
        productService.save(product);
        return "redirect:/smk/admin/product/list-product";
    }
    @GetMapping("update-product/{idPropduct}")
    public String updateHome(Model model,@ModelAttribute("idPropduct")Long id){
        Product product = productService.findByIdProduct(id);
        model.addAttribute("product",product);
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categorys",categoryList);
        return "admin/product/update";
    }
    @PostMapping("update-product")
    public String updatePost(@RequestParam("file")MultipartFile file,@ModelAttribute("product")Product product,Model model){
        Category category = categoryService.cFindById(Long.valueOf(request.getParameter("categoryId")));
        product.setCategory(category);
        Account account = sessionService.get(SessionAttr.CURRENT_USER);
        product.setModifiedBy(account.getUsername());
        product.setModifiedDate(new Date().toInstant());
        product.setImage(uploadService.posst(file));
        productService.saveAndFlush(product);
        return "redirect:/smk/admin/product/list-product";
    }
    @GetMapping("delete-product/{idPropduct}")
    public String Delete(Model model,@ModelAttribute("idPropduct")Long id){
        try {
            productService.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/smk/admin/product/list-product";
    }
}
