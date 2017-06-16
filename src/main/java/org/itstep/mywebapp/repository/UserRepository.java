package org.itstep.mywebapp.repository;

import org.itstep.mywebapp.model.User;

import java.util.List;

public interface UserRepository {

    List<User> getAll();

}
