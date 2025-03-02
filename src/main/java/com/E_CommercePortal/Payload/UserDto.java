package com.E_CommercePortal.Payload;

import jakarta.persistence.Column;

public class UserDto {
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String mobile;
    private String password;

    public  UserDto(){

    }

    public UserDto(Integer id, String firstName, String email, String lastName, String mobile, String password) {
        this.id = id;
        this.firstName = firstName;
        this.email = email;
        this.lastName = lastName;
        this.mobile = mobile;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

}
