package dao.custom.impl;

import dao.custom.orderDAO;
import entity.order;
import servlet.itemServlet;
import servlet.orderServlet;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class orderDAOImpl implements orderDAO {

    @Override
    public boolean add(order o) throws SQLException, ClassNotFoundException {
        Connection connection = orderServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO `Order` VALUES (?,?,?,?)");
        preparedStatement.setObject(1,o.getOrderID());
        preparedStatement.setObject(2,o.getOrderDate());
        preparedStatement.setObject(3,o.getOrderTime());
        preparedStatement.setObject(4,o.getCustID());


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
    public boolean update(order order) throws SQLException, ClassNotFoundException {
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


        Connection connection = orderServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `Order`");
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            String oderId = resultSet.getString(1);
            String orderDate = resultSet.getString(2);
            String orderTime = resultSet.getString(3);
            String id = resultSet.getString(4);


            objectBuilder.add("oderId", oderId);
            objectBuilder.add("orderDate", orderDate);
            objectBuilder.add("orderTime", orderTime);
            objectBuilder.add("id", id);

            jsonArrayBuilder.add(objectBuilder.build());


        }
        connection.close();
        return jsonArrayBuilder;
    }


    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        Connection connection = orderServlet.dataSource.getConnection();
        ResultSet resultSet = connection.prepareStatement("SELECT OrderID FROM `Order` ORDER BY OrderID DESC LIMIT 1").executeQuery();
        String s = null;
        if(resultSet.next()){
            s  = resultSet.getString(1);
        }
        connection.close();
        return s;

    }
}
