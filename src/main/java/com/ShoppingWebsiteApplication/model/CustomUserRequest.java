package com.ShoppingWebsiteApplication.model;

public class CustomUserRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String username;

    private String password;

    private String phone;

    private Address address;

    private Boolean active;
    private String roles = "";

    private String permissions = "";

//    public CustomUserRequest(String firstName, String lastName, String email, String username, String password, String phone, Address address, Boolean active) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.email = email;
//        this.username = username;
//        this.password = password;
//        this.phone = phone;
//        this.address = address;
//        this.active = active;
//    }

    public CustomUserRequest(String firstName, String lastName, String email, String username, String password, String phone, Address address, Boolean active, String roles, String permissions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.address = address;
        this.active = active;
        this.roles = roles;
        this.permissions = permissions;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public Boolean getActive() {
        return active;
    }

    public String getRoles() {
        return roles;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    public CustomUser toCustomUser(){
        return new CustomUser(
                null,
                this.firstName ,
                this.lastName ,
                this.email ,
                this.username,
                this.password ,
                this.phone,
               this.address,
                this.active,
                "",
                ""

        );
    }
}



