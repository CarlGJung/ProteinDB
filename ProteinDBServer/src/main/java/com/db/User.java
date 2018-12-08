package com.db;

import org.javalite.activejdbc.annotations.Table;

/**
 * @author zhanghaijun
 */
@Table("users")
public class User extends CommonModel {

    public static final String ID = "id";
    public static final String USER_NAME = "username";
    public static final String PASSWORD = "password";
    public static final String NICKNAME = "nickname";
    public static final String EMAIL = "email";
    public static final String PHONE = "phone";

    public int getID() {
        return getInteger(ID);
    }

    public String getUsername() {
        return getString(USER_NAME);
    }

    public void setUsername(String name) {
        setString(USER_NAME, name);
    }

    public String getPassword() {
        return getString(PASSWORD);
    }

    public void setPassword(String password) {
        setString(PASSWORD, password);
    }

    public String getFullName() {
        return getString(NICKNAME);
    }

    public void setFullName(String fullName) {
        setString(NICKNAME, fullName);
    }

    public String getEmail() {
        return getString(EMAIL);
    }

    public void setEmail(String email) {
        setString(EMAIL, email);
    }

    public String getPhone() {
        return getString(PHONE);
    }

    public void setPhone(String phone) {
        setString(PHONE, phone);
    }

}
