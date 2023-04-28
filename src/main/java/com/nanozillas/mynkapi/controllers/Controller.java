package com.nanozillas.mynkapi.controllers;

import com.nanozillas.mynkapi.Models.UserData;
import com.nanozillas.mynkapi.services.Services;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Call;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class Controller {

    @Autowired
    Services services;

    @RequestMapping("/")
    public String getIndex()
    {
        return ("hello world!!");
    }

    @RequestMapping("/api/v1/users")
    public List<UserData> getUsers()
    {
        return services.getAllUsers();
    }

    @PostMapping ("/api/v1/adduser")
    public void addUser(@RequestBody UserData user)
    {
        services.addUser(user);
    }

    @PostMapping ("/api/v1/send")
    public void addUser1(@RequestBody UserData user)
    {
        services.addUser(user);
    }
}
