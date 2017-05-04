package com.diachuk.twitter.repository;

import com.diachuk.twitter.domain.User;

import java.util.List;

/**
 * Created by Ivan_Diachuk on 4/14/2017.
 */
public interface UserRepository {

    User findById(Long aLong);

    void save(User user);

    List<User> findAll();

}
