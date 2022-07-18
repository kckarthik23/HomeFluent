package com.HomeFluent.Homeaccount.responseModels;

import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class UserRest {

    private int age;
    private String name;
    private BigInteger totalIncome;
    private String occupation;
    private String qualification;
    private LocalDateTime registrationDate;

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

    public BigInteger getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(BigInteger totalIncome) {
        this.totalIncome = totalIncome;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
        result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
        result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
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
        UserRest other = (UserRest) obj;
        if (age != other.age)
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
        if (qualification == null) {
            if (other.qualification != null)
                return false;
        } else if (!qualification.equals(other.qualification))
            return false;
        if (registrationDate == null) {
            if (other.registrationDate != null)
                return false;
        } else if (!registrationDate.equals(other.registrationDate))
            return false;
        if (totalIncome == null) {
            if (other.totalIncome != null)
                return false;
        } else if (!totalIncome.equals(other.totalIncome))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "UserRest [age=" + age + ", name=" + name + ", occupation=" + occupation + ", qualification="
                + qualification + ", registrationDate=" + registrationDate + ", totalIncome=" + totalIncome + "]";
    }

}
