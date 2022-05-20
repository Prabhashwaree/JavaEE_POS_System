package servlet;


import bo.BOFactory;
import bo.custom.impl.orderBOImpl;
import dto.orderDTO;
import entity.orderDetails;

import javax.annotation.Resource;
import javax.json.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(urlPatterns = "/order")
public class orderServlet extends HttpServlet {

    orderBOImpl orderBO = (orderBOImpl) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.ORDER);

    @Resource(name = "java:comp/env/jdbc/pool")
    public static DataSource dataSource;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        try {
            JsonArrayBuilder all = orderBO.getAll();
            PrintWriter writer = resp.getWriter();
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

            objectBuilder.add("status",200);
            objectBuilder.add("message","done");

            objectBuilder.add("data",objectBuilder.build());
            writer.print(objectBuilder.build());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader jsonReader = Json.createReader(req.getReader());
        JsonObject jsonObject = jsonReader.readObject();
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        String orderId = jsonObject.getString("orderId");
        String orderDate = jsonObject.getString("orderDate");
        String orderTime = jsonObject.getString("orderTime");
        String cusId = jsonObject.getString("cusId");

        JsonArray crat = jsonObject.getJsonArray("crat");
        ArrayList<orderDetails> orderDetail  = new ArrayList<>();

        for(int i=0;i<crat.size();i++){
            JsonObject jsonObject1 = crat.getJsonObject(i);

            String oId = jsonObject.getString("oId");
            String iCode = jsonObject.getString("iCode");
            String qty = jsonObject.getString("qty");
            String discount = jsonObject.getString("discount");
            String balance = jsonObject.getString("balance");

            orderDetail.add(new orderDetails(oId,iCode,qty,Double.parseDouble(discount),Double.parseDouble(balance)));

        }
        orderDTO orderDTO = new orderDTO();
        
    }
}
