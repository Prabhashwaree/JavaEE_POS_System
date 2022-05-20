package servlet;


import bo.BOFactory;
import bo.custom.impl.orderBOImpl;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;


@WebServlet(urlPatterns = "/order")
public class orderServlet extends HttpServlet {

    orderBOImpl orderBO = (orderBOImpl) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.ORDER);

    @Resource(name = "java:comp/env/jdbc/pool")
    public static DataSource dataSource;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader jsonReader = Json.createReader(req.getReader());
        JsonObject jsonObject = jsonReader.readObject();



    }
}
