package com.example.ShowMakerCode.Controller.AccoutController;

import com.example.ShowMakerCode.Entity.Account;
import com.example.ShowMakerCode.Service.EntiryService.AccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/smk/admin/account")
public class AccountAdminController {
    @Autowired
    AccountService accountService;
    @GetMapping("list-account")
    public String getListAccount(Model model){
        List<Account> accountList = accountService.getAllByActive();
        model.addAttribute("accountList",accountList);
        return "admin/account/homeAccount";
    }
    @GetMapping("update/{id}")
    public String getUpdateAccount(@PathVariable("id")Long idAccount,Model model){
        Account account = accountService.getAccountById(idAccount);
        model.addAttribute("accountUpdate",account);
        return "admin/account/updateAccount";
    }
    @PostMapping("update")
    public String postUpdate(Model model,@RequestParam("dayOfBirth")Date dob,@ModelAttribute("accountUpdate")Account accountUpdate){
        try {
            accountUpdate.setDob(dob);
            accountService.saveAndFlush(accountUpdate);
        }catch (Exception e){
            model.addAttribute("accountUpdate",accountUpdate);
            return "admin/account/updateAccount";
        }
        return "redirect:/smk/admin/account/list-account";
    }

    @GetMapping("remove/{id}")
    public String getDelete(@PathVariable("id")Long idAccount){
        Account account = accountService.getAccountById(idAccount);
        account.setStatus((byte) 0);
        accountService.saveAndFlush(account);
        return "redirect:/smk/admin/account/list-account";
    }

}
