package servlet;

import bo.BOFactory;
import bo.custom.customerBO;
import dto.customerDTO;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(urlPatterns = "/customer")
public class customerServlet extends HttpServlet {
    private final customerBO cusBO = (customerBO) BOFactory.getBOFactory().getBO(BOFactory.BoTypes.CUSTOMER);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String custID = req.getParameter("CustID");
        String custName = req.getParameter("CustName");
        String custAddress = req.getParameter("CustAddress");
        String salary = req.getParameter("Salary");

        PrintWriter writer = resp.getWriter();
        customerDTO cusDTO = new customerDTO(custID,custName,custAddress,salary);

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
}
