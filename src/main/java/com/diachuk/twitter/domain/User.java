package com.diachuk.twitter.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class User {

    static long idCounter = 1L;

    private long id;
    private String name;

    private List<User> friends = new ArrayList<>();

    public User() {
        this.id = idCounter++;
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", friends=" + friends +
                '}';
    }
}
