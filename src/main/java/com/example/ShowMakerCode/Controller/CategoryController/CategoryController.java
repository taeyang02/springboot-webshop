package com.example.ShowMakerCode.Controller.CategoryController;

import com.example.ShowMakerCode.Constant.SessionAttr;
import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Entity.Category;
import com.example.ShowMakerCode.Service.EntiryService.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("smk/admin/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    HttpServletRequest request;
    @GetMapping("add-category")
    public String addHomePage(Model model){
        model.addAttribute("category",new Category());
        return "admin/category/addCategory";
    }
    @PostMapping("add-category")
    public String addCategory(@ModelAttribute("category")Category category){
        category.setCreateDate(new Date().toInstant());
        Account account = (Account) request.getSession().getAttribute(SessionAttr.CURRENT_USER);
        category.setCreateBy(account.getUsername());
        try {
            categoryService.save(category);
        }catch (Exception e){
            return "redirect:/smk/admin/category/add-category";
        }
        return "redirect:/smk/admin/category/list-category";
    }

    @GetMapping("list-category")
    public String listCategory(Model model){
        List<Category> listCategory = categoryService.findAll();
        model.addAttribute("listCategory",listCategory);
        return "admin/category/list";
    }

    @GetMapping("category-update/{id}")
    public String update(Model model,@PathVariable("id")Long idCategory){
        Category categoryUpdate = categoryService.cFindById(idCategory);
        model.addAttribute("category",categoryUpdate);
        return "admin/category/updatecategory";
    }
    @PostMapping("category-update")
    public String submitUpdate(@ModelAttribute("category")Category category,Model model){
        Category categoryUpdate = categoryService.cFindById(category.getId());
        categoryUpdate.setName(category.getName());
        categoryUpdate.setCode(category.getCode());
        Account account = (Account) request.getSession().getAttribute(SessionAttr.CURRENT_USER);
        categoryUpdate.setModifiedBy(account.getUsername());
        categoryUpdate.setModifiedDate(new Date().toInstant());
        try {
            categoryService.saveAndFlush(categoryUpdate);
        }catch (Exception e){
            System.out.println("Trùng Mã Code");
            model.addAttribute("category",category);
            return "admin/category/updatecategory";
        }
        return "redirect:/smk/admin/category/list-category";
    }

}
