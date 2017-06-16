package org.itstep.mywebapp.web;

import org.itstep.mywebapp.model.User;
import org.itstep.mywebapp.repository.MockUserRepository;
import org.itstep.mywebapp.repository.UserRepository;
import org.itstep.mywebapp.service.UserService;
import org.itstep.mywebapp.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<User> all = service.getAll();

        PrintWriter writer = resp.getWriter();
        writer.write(all.toString());
        writer.close();

    }

}
