package com.HomeFluent.Homeaccount.dto;


import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class UserDto implements Serializable {

    private int age;
    private String name;
    private BigInteger toatalIncome;
    private String occupation;
    private String qualification;
    private LocalDateTime localDateAndTime;
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
    /**
     * @return the localDateAndTime
     */
    public LocalDateTime getLocalDateAndTime() {
        return localDateAndTime;
    }
    /**
     * @param localDateAndTime the localDateAndTime to set
     */
    public void setLocalDateAndTime(LocalDateTime localDateAndTime) {
        this.localDateAndTime = localDateAndTime;
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
    public BigInteger getToatalIncome() {
        return toatalIncome;
    }
    public void setToatalIncome(BigInteger toatalIncome) {
        this.toatalIncome = toatalIncome;
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
        return "User [age=" + age + ", name=" + name + ", occupation=" + occupation + ", qualification=" + qualification
                + ", toatalIncome=" + toatalIncome + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((occupation == null) ? 0 : occupation.hashCode());
        result = prime * result + ((qualification == null) ? 0 : qualification.hashCode());
        result = prime * result + ((toatalIncome == null) ? 0 : toatalIncome.hashCode());
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
        if (toatalIncome == null) {
            if (other.toatalIncome != null)
                return false;
        } else if (!toatalIncome.equals(other.toatalIncome))
            return false;
        return true;
    }

    
}
