package org.itstep.mywebapp.service;

import org.itstep.mywebapp.model.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    void delete(Integer id);
}
