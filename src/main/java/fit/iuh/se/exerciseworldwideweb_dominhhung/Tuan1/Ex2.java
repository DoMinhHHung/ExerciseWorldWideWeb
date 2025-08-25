package fit.iuh.se.exerciseworldwideweb_dominhhung.Tuan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "indexServerlet", urlPatterns = {"/index"})
public class Ex2 extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.println("<html><body>");
        writer.println("<h1>Index Servlet 123</h1>");
        writer.println("<p><a href=\"http://localhost:8080/ExerciseWorldWideWeb_DoMinhHung_war_exploded/json\">Đi đến trang JSON</a></p>");

        writer.println("</body></html>");
    }


}
