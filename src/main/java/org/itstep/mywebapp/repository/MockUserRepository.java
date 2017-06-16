package org.itstep.mywebapp.repository;

import org.itstep.mywebapp.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MockUserRepository implements UserRepository {

    private Map<Integer, User> users = new ConcurrentHashMap<>();

    {
        users.put(1, new User(1,"Mike", LocalDateTime.now()));
        users.put(2, new User(2, "Natasha", LocalDateTime.now()));
    }

    public List<User> getAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void delete(Integer id) {
        users.remove(id);
    }

    @Override
    public User get(Integer id) {
        return users.get(id);
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }


}
