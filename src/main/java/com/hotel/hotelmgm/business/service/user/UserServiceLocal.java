package com.hotel.hotelmgm.business.service.user;

import com.hotel.hotelmgm.business.model.User;

import java.util.List;

public interface UserServiceLocal {

    List<User> findAll();

    User login(String username, String plainPassword);

    void create(User user);

    void remove(User entity);

    void removeById(Integer id);

}
