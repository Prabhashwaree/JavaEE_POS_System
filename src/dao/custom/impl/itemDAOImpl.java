package dao.custom.impl;

import dao.custom.itemDAO;
import entity.item;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.SQLException;

public class itemDAOImpl implements itemDAO {

    @Override
    public boolean add(item item) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(item item) throws SQLException, ClassNotFoundException {
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
