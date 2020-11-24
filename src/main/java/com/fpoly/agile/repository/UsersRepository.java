package com.fpoly.agile.repository;

import com.fpoly.agile.model.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UsersRepository extends CrudRepository<Users, Integer> {
    @Query("select a from Users a where a.Email = :Email and a.Password = :Password")
    public Users login(@Param("Email") String username, @Param("Password") String pass);
}