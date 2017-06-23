package org.itstep.mywebapp.service;

import org.itstep.mywebapp.model.User;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {

    private static UserService service;
    private static ClassPathXmlApplicationContext context;

    // перед всеми тестами
    @BeforeClass
    public static void loadContext() {
        context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        service = context.getBean(UserService.class);
    }

    @AfterClass
    public static void cloaseContext() {
        context.close();
    }

    // перед каждым тестом
    @Before
    public void method() {

    }

    @Test
    public void getAll() throws Exception {
        List<User> all = service.getAll();
        assertEquals(2, all.size());
    }

    @Test
    public void delete() throws Exception {
        service.delete(1);
        assertEquals(1, service.getAll().size());
    }

    @Test
    public void get() throws Exception {
        User user = service.get(2);
        assertEquals("Natasha", user.getName());
    }

    @Test
    public void save() throws Exception {
        User petya = service.save(new User("Petya"));
        assertEquals(new Integer(3), petya.getId());
        assertEquals(3, service.getAll().size());
    }

}