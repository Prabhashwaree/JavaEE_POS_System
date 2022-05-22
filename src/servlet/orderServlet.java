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
            JsonArrayBuilder allItem = orderBO.getAll();
            PrintWriter writer = resp.getWriter();
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
            objectBuilder.add("status", 200);
            objectBuilder.add("message", "Done");
            objectBuilder.add("data", allItem.build());
            writer.print(objectBuilder.build());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        JsonReader jsonReader = Json.createReader(req.getReader());
        JsonObject jsonObject = jsonReader.readObject();
        resp.setContentType("application/json");

        PrintWriter writer = resp.getWriter();
        String oId = jsonObject.getString("oId");
        //System.out.println(orderId);
        String orderDate = jsonObject.getString("oDate");
        // System.out.println(orderDate);
        String orderTime = jsonObject.getString("oTime");
        //  System.out.println(orderTime);
        String cusId = jsonObject.getString("cId");


        JsonArray crats = jsonObject.getJsonArray("crat");
        ArrayList<orderDetailsDTO> orderDetail  = new ArrayList<>();

        for(int i=0;i<crats.size();i++){

            JsonObject details = crats.getJsonObject(i);
            System.out.println(details);


            String itemCode1 = details.getString("itemCode1");
            System.out.println(itemCode1);
            String itName1 = details.getString("itName1");
            System.out.println(itName1);
            String orderQty1=details.getString("orderQty1");
            System.out.println(orderQty1);

            String discounts = details.getString("discounts");
            System.out.println(discounts);
            int total2  = details.getInt("total2");
            System.out.println(total2);

            orderDetail.add(new orderDetailsDTO(oId,itemCode1,orderQty1,Double.parseDouble(discounts),total2));

        }
        orderDTO orderDTO = new orderDTO(oId,orderDate,orderTime,cusId,orderDetail);

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

