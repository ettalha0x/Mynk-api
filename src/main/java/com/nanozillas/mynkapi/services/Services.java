package com.nanozillas.mynkapi.services;

import com.nanozillas.mynkapi.Models.UserData;
import com.nanozillas.mynkapi.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Services {

    @Autowired
    private UserRepo repo;

     public List<UserData> getAllUsers()
     {
         return (repo.findAll());
     }

     public Optional<UserData> getUserById(long id)
     {
         return (repo.findById(id));
     }

     public UserData addUser(UserData user)
     {
         return (repo.save(user));
     }

}
