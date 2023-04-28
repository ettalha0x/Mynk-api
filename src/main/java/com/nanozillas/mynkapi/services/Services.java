package com.nanozillas.mynkapi.services;

import com.nanozillas.mynkapi.Models.Transactions;
import com.nanozillas.mynkapi.Models.User;
import com.nanozillas.mynkapi.repository.TransactionsRepo;
import com.nanozillas.mynkapi.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Services {

    @Autowired
    private UserRepo repo;
    @Autowired
    private TransactionsRepo transactionsRepo;

     public List<User> getAllUsers()
     {
         return (repo.findAll());
     }
     public List<Transactions> getAllTransactions()
    {
        return (transactionsRepo.findAll());
    }

     public Optional<User> getUserById(long id)
     {
         return (repo.findById(id));
     }

     public User addUser(User user)
     {
         return repo.save(user);
     }

     public String addTransactions(Transactions trans)
     {
         User srcUser = repo.findByPhoneNumber(trans.getPhone());
         srcUser.setBudget(srcUser.getBudget() - trans.getAmount());
         repo.saveAndFlush(srcUser);
         trans.setTransactionId(UUID.randomUUID().toString());
         return ("http://3719b7827d39.bfdc90b8.alx-cod.online:8080/" + transactionsRepo.save(trans).getTransactionId());
     }

     public Optional<Transactions> getTransaction(String transId)
     {
         return (transactionsRepo.findByTransactionId(transId));
     }

    public User confirmTransaction(
            Optional<Transactions> trans,
            String firstName,
            String lastName)
    {
        User user = new User();
        user.setPhoneNumber(trans.get().getTargetPhone());
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setBudget(trans.get().getAmount());
        return (addUser(user));
    }

    public void deleteAll()
    {
        repo.deleteAll();
        transactionsRepo.deleteAll();
    }

}
