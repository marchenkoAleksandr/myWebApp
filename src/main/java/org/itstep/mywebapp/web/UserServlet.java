package org.itstep.mywebapp.web;

import org.itstep.mywebapp.model.User;
import org.itstep.mywebapp.service.UserService;
import org.itstep.mywebapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(loadOnStartup = 1, value = "/users")
public class UserServlet extends HttpServlet {

    private UserService service;

    private ClassPathXmlApplicationContext context;

//    public void setService(UserService service) {
//        this.service = service;
//    }

    @Override
    public void init() throws ServletException {
        super.init();
        context = new ClassPathXmlApplicationContext("spring/spring-app.xml");
        service = context.getBean(UserService.class);
    }

    @Override
    public void destroy() {
        super.destroy();
        context.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (action != null) {
            if ("create".equals(action)){
                User user = service.save(new User());
                req.setAttribute("user", user);
                req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
                return;
            }

            Integer id = Integer.valueOf(req.getParameter("id"));
            if (action.equals("delete")) {
                service.delete(id);
                resp.sendRedirect("users"); // запрос возвращается через бразуер, как новый, атрибуты не сохраняются
            } else if (action.equals("update")) {
                User user = service.get(id);
                req.setAttribute("user", user);
                req.getRequestDispatcher("/editUser.jsp").forward(req, resp);
            }


        } else {
            List<User> userList = service.getAll();
            req.setAttribute("userList", userList);
            req.getRequestDispatcher("/userList.jsp").forward(req, resp); // запрос перенаправляется на сервере, атрибуты сохраняются
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.valueOf(req.getParameter("id"));
        User user = service.get(id);
        user.setName(req.getParameter("name"));
        service.save(user);
        resp.sendRedirect("users");

    }
}
