package org.itstep.mywebapp.repository;

import org.itstep.mywebapp.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

    void delete(Integer id);

    User get(Integer id);

    void save(User user);
}
