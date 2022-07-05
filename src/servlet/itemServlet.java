package servlet;

import bo.BOFactory;
import bo.custom.impl.itemBOImpl;
import dto.customerDTO;
import dto.itemDTO;

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

@WebServlet(urlPatterns = "/item")
public class itemServlet extends HttpServlet {

    @Resource(name = "java:comp/env/jdbc/pool")
    public static DataSource dataSource;

    private final itemBOImpl itemBOImpl = (itemBOImpl) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.ITEM);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        try {
            JsonArrayBuilder jsonArrayBuilder = itemBOImpl.getAllItem();
            JsonObjectBuilder objectBuilder = Json.createObjectBuilder();

            objectBuilder.add("status",200);
            objectBuilder.add("message","done");

            objectBuilder.add("data",jsonArrayBuilder.build());
            writer.print(objectBuilder.build());

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("itemCode");
        String name = req.getParameter("itemName");
        String price = req.getParameter("itemPrice");
        String qty = req.getParameter("itemQTY");

        PrintWriter writer = resp.getWriter();
        itemDTO iteDTO = new itemDTO(code,name,Double.parseDouble(price),qty);

        resp.setContentType("application/json");

        try {
            if (itemBOImpl.addItem(iteDTO)){
                JsonObjectBuilder responce = Json.createObjectBuilder();
                resp.setStatus(HttpServletResponse.SC_CREATED);
                responce.add("status",200);
                responce.add("message","Sucssesfull added");
                responce.add("data","");
                writer.print(responce.build());


            }
        } catch (SQLException e) {
            e.printStackTrace();
            JsonObjectBuilder object = Json.createObjectBuilder();
            object.add("status",400);
            object.add("message","Not added Item");
            object.add("data",e.getLocalizedMessage());
            writer.print(object.build());
            resp.setStatus(HttpServletResponse.SC_OK);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JsonObjectBuilder object = Json.createObjectBuilder();
            object.add("status",400);
            object.add("message","Not added Item");
            object.add("data",e.getLocalizedMessage());
            writer.print(object.build());
            resp.setStatus(HttpServletResponse.SC_OK);

        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader jsonReader = Json.createReader(req.getReader());
        JsonObject jsonObject = jsonReader.readObject();

        String iCode = jsonObject.getString("iCode");
        String itName = jsonObject.getString("itName");
        String iPrice = jsonObject.getString("iPrice");
        String iQuantity = jsonObject.getString("iQuantity");

        itemDTO iDTO = new itemDTO(iCode,itName,Double.parseDouble(iPrice),iQuantity);

        PrintWriter writer  = resp.getWriter();


        resp.setContentType("application/json");

        try {
            if(itemBOImpl.updateItem(iDTO)){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder.add("status",200);
                jsonObjectBuilder.add("message","Update Item..");
                jsonObjectBuilder.add("data","");
                writer.print(jsonObjectBuilder.build());

            }else {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
                objectBuilder.add("status",400);
                objectBuilder.add("message","Not Item Update..");
                objectBuilder.add("data","");
                writer.print(objectBuilder.build());
            }


        } catch (SQLException throwables) {
            //e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message"," Not Update Item..");
            jsonObjectBuilder.add("data",throwables.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());

        } catch (ClassNotFoundException e) {
            // e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message","Update Item..");
            jsonObjectBuilder.add("data",e.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());
        }

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("itemCode");
        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {
            if(itemBOImpl.deleteItem(code)){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder.add("status",200);
                jsonObjectBuilder.add("message","Delete Item..");
                jsonObjectBuilder.add("data","");
                writer.print(jsonObjectBuilder.build());

            }else {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
                objectBuilder.add("status",400);
                objectBuilder.add("message","Not Item Delete..");
                objectBuilder.add("data","");
                writer.print(objectBuilder.build());

            }


        } catch (SQLException e) {
            resp.setStatus(200);
            e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message","Delete Item..");
            jsonObjectBuilder.add("data",e.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.setStatus(200);
            //e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message","Delete Item..");
            jsonObjectBuilder.add("data",e.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());

        }
    }
}
