package com.nanozillas.mynkapi.repository;

import com.nanozillas.mynkapi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public User findByPhoneNumber(String phoneNumber);
}
