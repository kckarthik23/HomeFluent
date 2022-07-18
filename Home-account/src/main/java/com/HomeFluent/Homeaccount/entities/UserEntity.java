package com.HomeFluent.Homeaccount.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private int userId;
    @Column(name = "Age", nullable = false)
    private int age;
    @Column(name = "Name", unique = true, nullable = false)
    private String name;
    @Column(name = "TotalIncome", nullable = false)
    private BigInteger totalIncome;
    @Column(name = "Occupation", nullable = false)
    private String occupation;
    @Column(name = "Qualification", nullable = false)
    private String qualification;
    @Column(name = "Registration_Date", nullable = false)
    private LocalDateTime registrationDate;
    @Column(name = "Password", unique = true, nullable = false)
    private String password;
}
