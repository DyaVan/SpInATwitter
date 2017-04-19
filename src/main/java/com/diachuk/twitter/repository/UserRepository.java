package com.diachuk.twitter.repository;

import com.diachuk.twitter.domain.User;

/**
 * Created by Ivan_Diachuk on 4/14/2017.
 */
public interface UserRepository {

    User findById(Long aLong);

}
