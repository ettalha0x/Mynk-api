package com.nanozillas.mynkapi.controllers;

import com.nanozillas.mynkapi.Models.Transactions;
import com.nanozillas.mynkapi.Models.User;
import com.nanozillas.mynkapi.services.Services;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class Controller {

    @Autowired
    Services services;

//    @RequestMapping("/")
//    public String getIndex()
//    {
//        return ("index");
//    }

    @RequestMapping("/api/v1/users")
    public List<User> getUsers()
    {
        return services.getAllUsers();
    }

    @PostMapping ("/api/v1/adduser")
    public void addUser(@RequestBody User user)
    {
        services.addUser(user);
    }

    @DeleteMapping ("/deleteall")
    public void deleteAllUser()
    {
        services.deleteAll();
    }

    @PostMapping ("/api/v1/send")
    public String addTransaction(@RequestBody Transactions trans)
    {

        return services.addTransactions(trans);
    }

    @GetMapping("/{transactionsId}")
    public Optional<Transactions> getTransaction(@PathVariable(value = "transactionsId") String transId)
    {
        return (services.getTransaction(transId));
    }

    @PostMapping("/{transactionsId}/confirm/{first}/{last}")
    public User confirmTransaction(
            @PathVariable(value = "transactionsId") String transId,
            @PathVariable(value = "first") String firstName,
            @PathVariable(value = "last") String lastName)
    {
        return (services.confirmTransaction(services.getTransaction(transId), firstName, lastName));
    }
}
