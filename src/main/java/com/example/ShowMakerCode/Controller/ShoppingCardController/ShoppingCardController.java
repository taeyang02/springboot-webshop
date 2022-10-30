package com.example.ShowMakerCode.Controller.ShoppingCardController;

import com.example.ShowMakerCode.Service.MyService.SessionService;
import com.example.ShowMakerCode.Entity.Product;
import com.example.ShowMakerCode.Entity.ShoppingCard;
import com.example.ShowMakerCode.Service.EntiryService.CategoryService;
import com.example.ShowMakerCode.Service.EntiryService.ProductService;
import com.example.ShowMakerCode.Service.EntiryService.ShoppingCardService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
@Controller
@RequestMapping("smk")
public class ShoppingCardController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Autowired
    ShoppingCardService shoppingCardService;
    @Autowired
    SessionService sessionService;
    @GetMapping("/card")
    public String shoppingCard(Model model){
        Collection<ShoppingCard> cardItems = shoppingCardService.getCardItems();
        model.addAttribute("cardItems",cardItems);
        model.addAttribute("total",shoppingCardService.getAmount());
        model.addAttribute("noOfItems",shoppingCardService.getCount());
        return "site/shoppingcard/home";
    }
    @GetMapping("/card/add/{idAddToCard}")
    public String add(@PathVariable("idAddToCard")Long productId){
        String size;
        if (request.getParameter("size")==null){
            size = "S";
        }else {
            size = request.getParameter("size");
        }
        Product product = productService.findByIdProduct(productId);
        if (product != null){
            ShoppingCard item = new ShoppingCard();
            BeanUtils.copyProperties(product,item);
            item.setSize(size);
            item.setQuantity(1);
            shoppingCardService.add(item);
        }
        sessionService.set("countCard",shoppingCardService.getCount());
        return "redirect:"+sessionService.get("urlMainText");
    }
    @GetMapping("card/remove/{idAddToCard}")
    public String remove(@PathVariable("idAddToCard")String idProduct){
        sessionService.set("countCard",shoppingCardService.getCount());
        shoppingCardService.remove(idProduct);
        return "redirect:/smk/card";
    }
    @GetMapping("card/update")
    public String update(Model model, @ModelAttribute("quantity")Integer quantity, @ModelAttribute("idpro")String productId){
        shoppingCardService.update(productId,quantity);
        return "redirect:/smk/card";
    }
    @GetMapping("card/clear")
    public String clear(){
        shoppingCardService.clear();
        sessionService.set("countCard",shoppingCardService.getCount());
        return "redirect:/smk/card";
    }
}
