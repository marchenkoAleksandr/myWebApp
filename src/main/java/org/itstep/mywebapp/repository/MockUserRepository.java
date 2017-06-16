package org.itstep.mywebapp.repository;

import org.itstep.mywebapp.model.User;

import java.util.ArrayList;
import java.util.List;

public class MockUserRepository {

    private List<User> userList = new ArrayList<>();

    {
        userList.add(new User("Mike"));
        userList.add(new User("Natasha"));

    }

    public List<User> getAll() {
        return userList;
    }


}
