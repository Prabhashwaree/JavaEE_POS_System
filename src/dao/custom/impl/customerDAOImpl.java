package dao.custom.impl;

import dao.custom.customerDAO;
import entity.customer;

import javax.annotation.Resource;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class customerDAOImpl implements customerDAO {

    @Resource(name = "java:comp/env/jdbc/pool")
    DataSource ds;

    @Override
    public boolean add(customer customer) throws SQLException, ClassNotFoundException {

        Connection connection = ds.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Customer VALUES ?,?,?,?");
        preparedStatement.setObject(1,customer.getCustID());
        preparedStatement.setObject(2,customer.getCustName());
        preparedStatement.setObject(3,customer.getCustAddress());
        preparedStatement.setObject(4,customer.getSalary());

        preparedStatement.executeUpdate();
        connection.close();

        return preparedStatement.executeUpdate()>0;
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
