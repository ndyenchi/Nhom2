package com.example.demo.DTO;

import javax.validation.constraints.NotBlank;

public class RegisterUserRequest {
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDoB() {
        return DoB;
    }
    public void setDoB(String DoB) {
        this.DoB = DoB;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPotential() {
        return potential;
    }
    public void setPotential(String potential) {
        this.potential = potential;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @NotBlank(message = "username is mandatory")
    private String username;
    @NotBlank(message = "password is mandatory")
    private String password;
    @NotBlank(message = "name is mandatory")
    private String name;
    private String DoB;
    @NotBlank(message = "address is mandatory")
    private String address;
    @NotBlank(message = "potential is mandatory")
    private String potential;
    private String note;
    @NotBlank(message = "email is mandatory")
    private String email;
}
