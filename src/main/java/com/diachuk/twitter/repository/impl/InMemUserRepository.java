package com.diachuk.twitter.repository.impl;

import com.diachuk.twitter.domain.Tweet;
import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan_Diachuk on 4/14/2017.
 */
@Component
public class InMemUserRepository implements UserRepository {

    private HashMap<Long,User> users = new HashMap<>();

    @PostConstruct
    public void initialize(){
        User user1 = new User(1L, "Ivan");
        User user2 = new User(2L, "Vasya");

        users.put(user1.getId() ,user1);
        users.put(user2.getId() ,user2);
    }

    @Override
    public User findById(Long id) {
        return users.get(id);
    }

}
