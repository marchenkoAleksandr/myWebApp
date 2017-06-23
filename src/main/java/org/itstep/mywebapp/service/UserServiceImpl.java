package org.itstep.mywebapp.service;

import org.itstep.mywebapp.model.User;
import org.itstep.mywebapp.repository.MockUserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {

    private MockUserRepository repository = new MockUserRepository();

    @Override
    public List<User> getAll() {
        return repository.getAll();
    }

    @Override
    public void delete(Integer id) {
        repository.delete(id);
    }

    @Override
    public User get(Integer id) {
        return repository.get(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

}
