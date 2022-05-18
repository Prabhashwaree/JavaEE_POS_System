package dao.custom;

import dao.crudDAO;
import entity.order;

import java.sql.SQLException;

public interface orderDAO extends crudDAO<order,String> {
    String generateNewOrderId() throws SQLException, ClassNotFoundException;
}
