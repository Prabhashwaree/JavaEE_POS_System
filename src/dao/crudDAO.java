package dao;

import dao.superDAO;

import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.SQLException;

public interface crudDAO<T,ID> extends superDAO {
    boolean add(T t) throws SQLException, ClassNotFoundException;

    boolean delete(ID id) throws SQLException, ClassNotFoundException;

    boolean update(T t) throws SQLException, ClassNotFoundException;

    JsonObjectBuilder search(ID id) throws SQLException, ClassNotFoundException;

    JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException;
}
