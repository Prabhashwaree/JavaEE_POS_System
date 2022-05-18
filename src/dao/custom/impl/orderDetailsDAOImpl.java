package dao.custom.impl;

import dao.custom.orderDetailsDAO;
import entity.orderDetails;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.SQLException;

public class orderDetailsDAOImpl implements orderDetailsDAO {
    @Override
    public boolean add(orderDetails orderDetails) throws SQLException, ClassNotFoundException {
        return false;
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
        return null;
    }

    @Override
    public orderDetails getOrder(String id) throws SQLException, ClassNotFoundException {
        return null;
    }
}
