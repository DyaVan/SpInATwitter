package com.diachuk.twitter.domain;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VA-N_ on 03.04.2017.
 */
public class User {

    static long idCounter = 1L;

    private long id;

    @NotNull
    @javax.validation.constraints.Size(min = 5,max = 10)
    private String name;

    @NotNull
    @javax.validation.constraints.Size(min = 1,max = 8)
    private String password;

    private List<User> friends = new ArrayList<>();

    public User() {
        this.id = idCounter++;
    }

    public User( String name,String password) {
        this.id = idCounter++;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
