package org.itstep.mywebapp.model;

import java.time.LocalDateTime;

public class User {

    private Integer id;

    private String name;

    private LocalDateTime registered;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", registered=" + registered +
                '}';
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }

    public User(Integer id, String name, LocalDateTime registered) {
        this.id = id;
        this.name = name;
        this.registered = registered;
    }
}
