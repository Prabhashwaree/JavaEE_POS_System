package dao.custom;

import dao.crudDAO;
import entity.customer;

import java.sql.SQLException;

public interface customerDAO extends crudDAO<customer,String> {
//    boolean ifCustomerExit(String id)throws SQLException, ClassNotFoundException;
}
