package com.fpoly.agile.service;

import com.fpoly.agile.model.Users;
import com.fpoly.agile.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("UsersService")
@Transactional
public class UserServiceImpl implements UsersService {
    @Autowired
    private UsersRepository rep;

    @Override
    public List<Users> findAll() {
        return (List<Users>) rep.findAll();
    }

    @Override
    public void save(Users user){
        rep.save(user);
    }

    @Override
    public void delete(Integer id){
        rep.deleteById(id);
    }

    @Override
    public Users get(Integer id){
        return rep.findById(id).get();
    }

    @Override
    public Users login(String Email, String Password) {
        return rep.login(Email, Password);
    }
    @Override
    public Users role(Boolean Role){
        return rep.role(Role);
    }
}
