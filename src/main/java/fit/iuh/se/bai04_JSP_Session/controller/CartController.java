package fit.iuh.se.bai04_JSP_Session.controller;

import fit.iuh.se.bai04_JSP_Session.model.CartBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action != null && !action.equals("")) {
            if (action.equals("add")) {
                addToCart(req);
                resp.sendRedirect("ModelList.jsp");
            } else if (action.equals("Update")) {
                updateCart(req);
                resp.sendRedirect("ShoppingCart.jsp");
            } else if (action.equals("Delete")) {
                deleteCart(req);
                resp.sendRedirect("ShoppingCart.jsp");
            }
        } else {
            resp.sendRedirect("ModelList.jsp");
        }
    }

    protected void deleteCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String strItemIndex = req.getParameter("itemIndex");
        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.deleteCartItem(strItemIndex);
    }

    protected void updateCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String strQuantity = req.getParameter("quantity");
        String strItemIndex = req.getParameter("itemIndex");

        CartBean cartBean = null;
        Object objCartBean = session.getAttribute("cart");
        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
        }
        cartBean.updateCartItem(strItemIndex, strQuantity);
    }

    protected void addToCart(HttpServletRequest req) {
        HttpSession session = req.getSession();
        String strModelNo = req.getParameter("modelNo");
        String strDescription = req.getParameter("description");
        String strPrice = req.getParameter("price");
        String strQuantity = req.getParameter("quantity");

        CartBean cartBean = null;

        Object objCartBean = session.getAttribute("cart");

        if (objCartBean != null) {
            cartBean = (CartBean) objCartBean;
        } else {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }

        cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
    }
}