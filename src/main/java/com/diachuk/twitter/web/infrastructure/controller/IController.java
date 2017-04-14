package com.diachuk.twitter.web.infrastructure.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ivan_Diachuk on 4/10/2017.
 */
public interface IController {

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
