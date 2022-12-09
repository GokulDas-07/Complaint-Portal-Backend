package com.nest.complaintportal_backend.dao;

import com.nest.complaintportal_backend.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserDao extends CrudRepository<User,Integer> {
    @Query(value = "SELECT `id`, `address`, `confirm`, `mail`, `name`, `password`, `phone` FROM `user` WHERE `mail`=:mail AND `password`=:password",nativeQuery = true)
    List<User> userLogin(@Param("mail") String mail, @Param("password")String password);

    @Query(value = "SELECT `id`, `address`, `confirm`, `mail`, `name`, `password`, `phone` FROM `user` WHERE `id`=:id",nativeQuery = true)
    List<User> userInfo(@Param("id") Integer id);
}
