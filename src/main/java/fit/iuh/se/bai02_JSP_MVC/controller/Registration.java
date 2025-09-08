package fit.iuh.se.bai02_JSP_MVC.controller;

import fit.iuh.se.bai02_JSP_MVC.entity.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bai02/register")
public class Registration extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private List<User> users = new ArrayList<>();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String reEmail = req.getParameter("reEmail");
        String password = req.getParameter("password");

        String gender = req.getParameter("gender");
        String month = req.getParameter("month");
        String day = req.getParameter("day");
        String year = req.getParameter("year");

        if (!email.equals(reEmail)) {
            req.setAttribute("error", "Email không khớp!");
            RequestDispatcher rd = req.getRequestDispatcher("user-registration-form.html");
            rd.forward(req, resp);
            return;
        }
        String dob = day + "-" + month + "-" + year;

        User user = new User(firstName, lastName, email, password, dob, gender);
        users.add(user);

        req.setAttribute("users", users);
        RequestDispatcher rd = req.getRequestDispatcher("regist.jsp");
        rd.forward(req, resp);
    }
}
