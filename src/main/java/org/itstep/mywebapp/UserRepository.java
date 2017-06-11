package org.itstep.mywebapp;

import java.util.ArrayList;
import java.util.List;

class UserRepository {

    private List<User> userList = new ArrayList<>();

    {
        userList.add(new User("Mike"));
        userList.add(new User("Natasha"));

    }

    List<User> getAll() {
        return userList;
    }


}
