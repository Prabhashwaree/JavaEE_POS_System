package dao.custom.impl;

import dao.custom.orderDAO;
import entity.order;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.SQLException;

public class orderDAOImpl implements orderDAO {

    @Override
    public boolean add(order order) throws SQLException, ClassNotFoundException {
        return false;
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
        return null;
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return null;
    }
}
