package org.itstep.mywebapp.repository;

import org.itstep.mywebapp.model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class MockUserRepository implements UserRepository {

    private Map<Integer, User> users = new ConcurrentHashMap<>();

    private AtomicInteger idCounter = new AtomicInteger(1);

    {
        save(new User("Mike"));
        save(new User("Natasha"));
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
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.getAndIncrement());
            user.setRegistered(LocalDateTime.now());
        }
        users.put(user.getId(), user);
        return user;
    }

}
