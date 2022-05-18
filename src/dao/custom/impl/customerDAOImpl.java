package dao.custom.impl;

import dao.custom.customerDAO;
import entity.customer;
import servlet.customerServlet;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class customerDAOImpl implements customerDAO {

    @Override
    public boolean add(customer c) throws SQLException, ClassNotFoundException {

        Connection connection = customerServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
        preparedStatement.setString(1,c.getCustID());
        preparedStatement.setString(2,c.getCustName());
        preparedStatement.setString(3,c.getCustAddress());
        preparedStatement.setDouble(4,c.getSalary());

//        System.out.println(c.getCustID());
//        System.out.println(c.getCustName());
//        System.out.println(c.getCustAddress());
//        System.out.println(c.getSalary());

        if(preparedStatement.executeUpdate()>0){
            connection.close();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Connection connection = customerServlet.dataSource.getConnection();

        if(connection.prepareStatement("DELETE FROM Customer WHERE CustID ='"+s+"'").executeUpdate()>0){
            connection.close();
            return true;

        }else {
            return false;
        }

    }

    @Override
    public boolean update(customer c) throws SQLException, ClassNotFoundException {
        Connection connection = customerServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Customer SET CustName = ?,CustAddress = ?,Salary = ? WHERE CustID = ?");
        preparedStatement.setString(1,c.getCustName());
        preparedStatement.setString(2,c.getCustAddress());
        preparedStatement.setDouble(3,c.getSalary());
        preparedStatement.setString(4,c.getCustID());

        if(preparedStatement.executeUpdate()>0){
            connection.close();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public JsonObjectBuilder search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();


        Connection connection = customerServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Customer");
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            String id = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            double salary = resultSet.getDouble(4);


            objectBuilder.add("id", id);
            objectBuilder.add("name", name);
            objectBuilder.add("address", address);
            objectBuilder.add("salary", salary);

            jsonArrayBuilder.add(objectBuilder.build());


        }
        connection.close();
        return jsonArrayBuilder;
    }
}
