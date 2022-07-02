package com.HomeFluent.Homeaccount.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userID")
    private int userId;
    @Column(name = "Age")
    private int age;
    @Column(name = "Name")
    private String name;
    @Column(name = "TotalIncome")
    private BigInteger toatalIncome;
    @Column(name = "Occupation")
    private String occupation;
    @Column(name = "Qualification")
    private String qualification;
    @Column(name = "Registration_Date")
    private LocalDateTime localDateAndTime;
    @Column(name = "Password")
    private String password;
}
