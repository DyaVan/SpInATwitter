package com.diachuk.twitter.service;

import com.diachuk.twitter.domain.Timeline;

/**
 * Created by Ivan_Diachuk on 4/14/2017.
 */
public interface TimeLineService {

    Timeline getUserTimeLine();

    Timeline getUserFullTimeLine();

}
