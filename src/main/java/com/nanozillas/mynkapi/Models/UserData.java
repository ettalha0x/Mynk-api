package com.nanozillas.mynkapi.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="user_table")
public class UserData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private long amount;
    private String timeOfTransaction;
    private String expiredTime;
    private String phone;
    private String paymentId;
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long targetUserId;
    private String targetUserFirstName;
    private String targetUserLastName;
    private String targetPhone;


}
