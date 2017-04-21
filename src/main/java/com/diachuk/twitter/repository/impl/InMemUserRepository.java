package com.diachuk.twitter.repository.impl;

import com.diachuk.twitter.domain.User;
import com.diachuk.twitter.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@Component("userRepository")
public class InMemUserRepository implements UserRepository {

    private HashMap<Long,User> users = new HashMap<>();

    @PostConstruct
    public void initialize(){
        User user1 = new User("Ivan","1");
        User user2 = new User("Vasya", "2");

        users.put(user1.getId() ,user1);
        users.put(user2.getId() ,user2);
    }


    @Override
    public User findById(Long id) {
        return users.get(id);
    }

    @Override
    public void save(User user) {
        users.put(user.getId(), user);
    }

    @Override
    public List<User> findAll() {
        return users.values().stream().collect(Collectors.toList());
    }


}
