package org.itstep.mywebapp.repository;

import org.itstep.mywebapp.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MockUserRepository implements UserRepository {

    private static final Logger LOG = LoggerFactory.getLogger(MockUserRepository.class);

    private Map<Integer, User> users = new ConcurrentHashMap<>();

    private AtomicInteger idCounter = new AtomicInteger(1);

    {
        save(new User("Mike"));
        save(new User("Natasha"));
    }

    public List<User> getAll() {
        LOG.debug("Get all users");
        return new ArrayList<>(users.values());
    }

    @Override
    public void delete(Integer id) {
        LOG.debug("Delete user with id = {}", id);
        users.remove(id);
    }

    @Override
    public User get(Integer id) {
        LOG.debug("Get user with id = {}", id);
        return users.get(id);
    }

    @Override
    public User save(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.getAndIncrement());
            user.setRegistered(LocalDateTime.now());
        }
        LOG.debug("Save user with id = {}", user.getId());
        users.put(user.getId(), user);
        return user;
    }

}
