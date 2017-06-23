package org.itstep.mywebapp;

import org.itstep.mywebapp.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class SpringExample {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        String[] beanDefinitionNames = context.getBeanDefinitionNames();

        Arrays.stream(beanDefinitionNames).forEach(System.out::println);

        UserService userService = context.getBean(UserService.class);
        System.out.println(userService.getAll());

    }

}
