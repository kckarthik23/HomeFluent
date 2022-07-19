package com.HomeFluent.Homeaccount.Security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserDetail extends User {
    private int userId;

    public UserDetail(String username, String password, Collection<? extends GrantedAuthority> authorities,
            int userId) {
        super(username, password, authorities);
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserDetailsService [userId=" + userId + "]";
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

}