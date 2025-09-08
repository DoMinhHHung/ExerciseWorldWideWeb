package fit.iuh.se.bai04_JSP_Session.controller;

import fit.iuh.se.bai04_JSP_Session.model.ProducList;
import fit.iuh.se.bai04_JSP_Session.model.Product;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class ProductListController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> list = ProducList.queryProduct();
        req.setAttribute("ds",list);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModelList.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
