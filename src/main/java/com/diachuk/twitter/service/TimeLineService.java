package com.diachuk.twitter.service;

import com.diachuk.twitter.domain.Timeline;
import com.diachuk.twitter.domain.User;

/**
 * Created by Ivan_Diachuk on 4/14/2017.
 */
public interface TimeLineService {

    Timeline getUserTimeLine(User user);

    Timeline getUserFullTimeLine(User user);

}
