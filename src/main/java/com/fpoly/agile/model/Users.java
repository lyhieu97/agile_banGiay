package com.fpoly.agile.model;

import javax.persistence.*;

@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer UsersID;
    private String Email;
    private String Pass;
    private String FullName;
    private String Address;
    private String Phone;
    private Boolean Role;

    public Users(){
    }

    public Users(Integer usersID, String email, String pass, String fullName, String address, String phone, Boolean role) {
        UsersID = usersID;
        Email = email;
        Pass = pass;
        FullName = fullName;
        Address = address;
        Phone = phone;
        Role = role;
    }

    @Override
    public String toString() {
        return "Users{" +
                "UsersID=" + UsersID +
                ", Email='" + Email + '\'' +
                ", Password='" + Pass + '\'' +
                ", FullName='" + FullName + '\'' +
                ", Address='" + Address + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Role=" + Role +
                '}';
    }

    public Integer getUsersID() {
        return UsersID;
    }

    public void setUsersID(Integer usersID) {
        UsersID = usersID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public Boolean getRole() {
        return Role;
    }

    public void setRole(Boolean role) {
        Role = role;
    }
}
