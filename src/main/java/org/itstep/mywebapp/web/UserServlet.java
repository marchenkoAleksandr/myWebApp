package org.itstep.mywebapp.web;

import org.itstep.mywebapp.model.User;
import org.itstep.mywebapp.service.UserService;
import org.itstep.mywebapp.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        System.out.println(action);
        if (action != null) {
            Integer id = Integer.valueOf(req.getParameter("id"));
            service.delete(id);
            resp.sendRedirect("users"); // запрос возвращается через бразуер, как новый, атрибуты не сохраняются
        } else {
            List<User> userList = service.getAll();
            req.setAttribute("userList", userList);
            req.getRequestDispatcher("/userList.jsp").forward(req, resp); // запрос перенаправляется на сервере, атрибуты сохраняются
        }

    }

}
