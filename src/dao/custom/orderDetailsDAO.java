package dao.custom;

import dao.crudDAO;
import entity.orderDetails;

import java.sql.SQLException;

public interface orderDetailsDAO extends crudDAO<orderDetails,String> {

    orderDetails getOrder(String id) throws SQLException, ClassNotFoundException;
}
