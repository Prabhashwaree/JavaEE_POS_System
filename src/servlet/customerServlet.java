package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(urlPatterns = "/customer")
public class customerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("testing.........");
//
//        String method = req.getMethod();
//        System.out.println("Request Method is "+method);
//        PrintWriter writer = resp.getWriter();
//        writer.write("Response from Customer Servlet Generated");
    }
}
