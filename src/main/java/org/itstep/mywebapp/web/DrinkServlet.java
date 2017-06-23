package org.itstep.mywebapp.web;

import org.itstep.mywebapp.Logged;
import org.itstep.mywebapp.service.DrinkService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DrinkServlet extends HttpServlet {

    private DrinkService service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer drinkId = 1;

        service.get(Logged.id, drinkId);

    }

}
