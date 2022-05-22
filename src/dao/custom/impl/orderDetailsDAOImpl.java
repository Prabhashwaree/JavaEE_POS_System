package dao.custom.impl;

import dao.custom.orderDetailsDAO;
import entity.orderDetails;
import servlet.itemServlet;
import servlet.orderDetailsServlet;
import servlet.orderServlet;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderDetailsDAOImpl implements orderDetailsDAO {
    @Override
    public boolean add(orderDetails od) throws SQLException, ClassNotFoundException {
        Connection connection = orderServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `Order Details` VALUES (?,?,?,?,?)");
        preparedStatement.setObject(1,od.getOrderID());
        preparedStatement.setObject(2,od.getItemCode());
        preparedStatement.setObject(3,od.getOrderqty());
        preparedStatement.setObject(4,od.getDiscount());
        preparedStatement.setObject(5,od.getBalance());


        if(preparedStatement.executeUpdate()>0){
            connection.close();
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(orderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public JsonObjectBuilder search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();


        Connection connection = orderDetailsServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Order Details`");
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            String oId = resultSet.getString(1);
            String iCode = resultSet.getString(2);
            String oQTY = resultSet.getString(3);
            double discount = resultSet.getDouble(4);
            double balance = resultSet.getDouble(5);


            objectBuilder.add("oId", oId);
            objectBuilder.add("iCode", iCode);
            objectBuilder.add("oQTY", oQTY);
            objectBuilder.add("discount", discount);
            objectBuilder.add("balance", balance);

            jsonArrayBuilder.add(objectBuilder.build());


        }
        connection.close();
        return jsonArrayBuilder;
    }

    @Override
    public orderDetails getOrder(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
