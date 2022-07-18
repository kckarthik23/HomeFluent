package com.HomeFluent.Homeaccount.dto;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class UserDto implements Serializable {

    private int age;
    private String name;
    private BigInteger totalIncome;
    private String occupation;
    private String qualification;
    private LocalDateTime registrationDate;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "UserDto [age=" + age + ", localDateAndTime=" + registrationDate + ", name=" + name + ", occupation="
                + occupation + ", password=" + password + ", qualification=" + qualification + ", totalIncome="
                + totalIncome + "]";
    }

    public BigInteger getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigInteger totalIncome) {
        this.totalIncome = totalIncome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
        result = prime * result + ((totalIncome == null) ? 0 : totalIncome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        UserDto other = (UserDto) obj;
        if (age != other.age)
            return false;
        if (registrationDate == null) {
            if (other.registrationDate != null)
                return false;
        } else if (!registrationDate.equals(other.registrationDate))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (occupation == null) {
            if (other.occupation != null)
                return false;
        } else if (!occupation.equals(other.occupation))
            return false;
        if (password == null) {
            if (other.password != null)
                return false;
        } else if (!password.equals(other.password))
            return false;
        if (qualification == null) {
            if (other.qualification != null)
                return false;
        } else if (!qualification.equals(other.qualification))
            return false;
        if (totalIncome == null) {
            if (other.totalIncome != null)
                return false;
        } else if (!totalIncome.equals(other.totalIncome))
            return false;
        return true;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

}
