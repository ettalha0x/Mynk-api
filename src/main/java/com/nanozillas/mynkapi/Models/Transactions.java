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
@Table(name="transactions_table")
public class Transactions implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String transactionId;
    private String firstName;
    private String lastName;
    private long amount;
    private String timeOfTransaction;
    private String expiredTime;
    private String phone;
    private String paymentId;
//    private String targetUserFirstName;
//    private String targetUserLastName;
    private String targetPhone;
//    private boolean confirmed;

}
