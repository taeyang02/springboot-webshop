package com.example.ShowMakerCode.Constant;

import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Entity.AccountRole;
import com.example.ShowMakerCode.Service.EntiryService.AccountRoleService;
import com.example.ShowMakerCode.Service.EntiryService.ShoppingCardService;
import com.example.ShowMakerCode.Service.MyService.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
@Service
public class SessionLogin {
    @Autowired
    AccountRoleService accountRoleService;
    @Autowired
    SessionService sessionService;
    @Autowired
    HttpServletRequest request;
    @Autowired
    ShoppingCardService shoppingCardService;

    public void userIsLogin(Account account){
        sessionService.set(SessionAttr.CURRENT_USER,account);
        AccountRole accountRole= accountRoleService.findByAccount(account);
        sessionService.set(SessionAttr.ROLE_ACCOUNT,accountRole.getRole().getName());
        sessionService.set("countCard",shoppingCardService.getCount());
    }
    public void logout(){
        sessionService.remove(SessionAttr.CURRENT_USER);
        sessionService.remove(SessionAttr.ROLE_ACCOUNT);
        shoppingCardService.clear();
        sessionService.set("countCard",shoppingCardService.getCount());

    }
    public void initaccount(Model model){
        Account account = (Account) request.getSession().getAttribute(SessionAttr.CURRENT_USER);
        String accountRole = (String) request.getSession().getAttribute(SessionAttr.ROLE_ACCOUNT);
        model.addAttribute("UserCurrent",account);
        model.addAttribute("UserRole",accountRole);
    }
}
