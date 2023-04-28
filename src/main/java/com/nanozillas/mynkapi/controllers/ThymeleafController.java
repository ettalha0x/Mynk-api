package com.nanozillas.mynkapi.controllers;

import com.fasterxml.jackson.databind.Module;
import com.nanozillas.mynkapi.Models.Transactions;
import com.nanozillas.mynkapi.Models.User;
import com.nanozillas.mynkapi.services.Services;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.tools.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
@AllArgsConstructor
@NoArgsConstructor
public class ThymeleafController {

    @Autowired
    Services services;
    @GetMapping("/")
    public String getIndex(Model model)
    {
        List<User> users = services.getAllUsers();
        model.addAttribute("users", users);
        List<Transactions> transactions = services.getAllTransactions();
        model.addAttribute("transactions", transactions);
        return ("index.html");
    }

}
