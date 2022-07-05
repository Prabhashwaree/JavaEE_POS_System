package servlet;

import bo.BOFactory;
import bo.custom.customerBO;
import bo.custom.impl.customerBOImpl;
import dto.customerDTO;

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


@WebServlet(urlPatterns = "/customer")
public class customerServlet extends HttpServlet {
    @Resource(name = "java:comp/env/jdbc/pool")
    public static DataSource dataSource;

    private final customerBOImpl cusBO = (customerBOImpl) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();

        try {
            JsonArrayBuilder jsonArrayBuilder = cusBO.getAllCustomer();
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
        String custID = req.getParameter("Cus_ID");
        String custName = req.getParameter("CustName");
        String custAddress = req.getParameter("CustAddress");
        String salary = req.getParameter("Salary");

//        System.out.println(custID);
//        System.out.println(custName);
//        System.out.println(custAddress);
//        System.out.println(salary);


        PrintWriter writer = resp.getWriter();
        customerDTO cusDTO = new customerDTO(custID,custName,custAddress,Double.parseDouble(salary));

        resp.setContentType("application/json");

        try {
            if (cusBO.addCustomer(cusDTO)){
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
            object.add("message","Not added Customer");
            object.add("data",e.getLocalizedMessage());
            writer.print(object.build());
            resp.setStatus(HttpServletResponse.SC_OK);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JsonObjectBuilder object = Json.createObjectBuilder();
            object.add("status",400);
            object.add("message","Not added Customer");
            object.add("data",e.getLocalizedMessage());
            writer.print(object.build());
            resp.setStatus(HttpServletResponse.SC_OK);

        }
    }


    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        JsonReader jsonReader = Json.createReader(req.getReader());
        JsonObject jsonObject = jsonReader.readObject();

        String cusId = jsonObject.getString("cusId");
        String cusName = jsonObject.getString("cusName");
        String cusAddress = jsonObject.getString("cusAddress");
        String cusSalary = jsonObject.getString("cusSalary");

        PrintWriter writer  = resp.getWriter();
        customerDTO cusDTO = new customerDTO(cusId,cusName,cusAddress,Double.parseDouble(cusSalary));

        resp.setContentType("application/json");

        try {
            if(cusBO.updateCustomer(cusDTO)){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder.add("status",200);
                jsonObjectBuilder.add("message","Update Customer..");
                jsonObjectBuilder.add("data","");
                writer.print(jsonObjectBuilder.build());

            }else {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
                objectBuilder.add("status",400);
                objectBuilder.add("message","Not customer Update..");
                objectBuilder.add("data","");
                writer.print(objectBuilder.build());
            }


        } catch (SQLException throwables) {
            //e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message"," Not Update customer..");
            jsonObjectBuilder.add("data",throwables.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());

        } catch (ClassNotFoundException e) {
           // e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message","Update customer..");
            jsonObjectBuilder.add("data",e.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());
        }

    }


    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String custID = req.getParameter("Cus_ID");

        PrintWriter writer = resp.getWriter();
        resp.setContentType("application/json");

        try {
            if(cusBO.deleteCustomer(custID)){
                JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
                jsonObjectBuilder.add("status",200);
                jsonObjectBuilder.add("message","Delete Customer..");
                jsonObjectBuilder.add("data","");
                writer.print(jsonObjectBuilder.build());

            }else {
                JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
                objectBuilder.add("status",400);
                objectBuilder.add("message","Not customer Delete..");
                objectBuilder.add("data","");
                writer.print(objectBuilder.build());

            }


        } catch (SQLException e) {
            resp.setStatus(200);
            e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message","Delete customer..");
            jsonObjectBuilder.add("data",e.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            resp.setStatus(200);
            //e.printStackTrace();
            JsonObjectBuilder jsonObjectBuilder = Json.createObjectBuilder();
            jsonObjectBuilder.add("status",500);
            jsonObjectBuilder.add("message","Delete customer..");
            jsonObjectBuilder.add("data",e.getLocalizedMessage());
            writer.print(jsonObjectBuilder.build());

        }
    }
}
