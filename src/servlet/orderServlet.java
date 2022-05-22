package servlet;


import bo.BOFactory;
import bo.custom.impl.orderBOImpl;
import dto.orderDTO;
import dto.orderDetailsDTO;
import entity.order;
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

            objectBuilder.add("data",all.build());
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

        JsonArray crat = jsonObject.getJsonArray("CRAT");
        ArrayList<orderDetailsDTO> orderDetail  = new ArrayList<>();

        for(int i=0;i<crat.size();i++){
//            JsonObject jsonObject1 = crat.getJsonObject(i);
//
//            String oId = jsonObject1.getString("oId");
//            String iCode = jsonObject1.getString("iCode");
//            String qty = jsonObject1.getString("qty");
//            String discount = jsonObject1.getString("discount");
//            String balance = jsonObject1.getString("balance");
//
//            orderDetail.add(new orderDetailsDTO(oId,iCode,qty,Double.parseDouble(discount),Double.parseDouble(balance)));

        }
        orderDTO orderDTO = new orderDTO(orderId,orderDate,orderTime,cusId,orderDetail);

        try {
            if(orderBO.placeOrder(orderDTO)){
                JsonObjectBuilder response = Json.createObjectBuilder();
                resp.setStatus(HttpServletResponse.SC_CREATED);//201
                response.add("status", 200);
                response.add("message", "Done");
                response.add("data", "Successfully Added");
                writer.print(response.build());

            }

        } catch (SQLException e) {
            e.printStackTrace();
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 400);
            response.add("message", "Error");
            response.add("data", e.getLocalizedMessage());
            writer.print(response.build());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JsonObjectBuilder response = Json.createObjectBuilder();
            response.add("status", 400);
            response.add("message", "Error");
            response.add("data", e.getLocalizedMessage());
            writer.print(response.build());

        }
    }
}
