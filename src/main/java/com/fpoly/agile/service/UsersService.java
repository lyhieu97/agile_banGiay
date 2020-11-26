package com.fpoly.agile.service;

import com.fpoly.agile.model.Users;

import java.util.List;

public interface UsersService {
    public List<Users> findAll();
    public void save(Users user);
    public void delete(Integer id);
    public Users get(Integer id);
    public Users login(String Email, String Password);
    public Users role(Boolean Role);

}
