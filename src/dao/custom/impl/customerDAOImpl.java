package dao.custom.impl;

import dao.custom.customerDAO;
import entity.customer;
import servlet.customerServlet;


import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
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

        System.out.println(c.getCustID());
        System.out.println(c.getCustName());
        System.out.println(c.getCustAddress());
        System.out.println(c.getSalary());

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
    public boolean update(customer customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public JsonObjectBuilder search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException {
        return null;
    }
}
