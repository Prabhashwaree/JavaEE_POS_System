package bo.custom;

import bo.superBO;
import dto.customerDTO;

import javax.json.JsonArrayBuilder;
import java.sql.SQLException;

public interface customerBO extends superBO {

    JsonArrayBuilder getAllCustomer() throws SQLException, ClassNotFoundException;

    boolean addCustomer(customerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean updateCustomer(customerDTO customerDTO) throws SQLException, ClassNotFoundException;

    boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;

    boolean ifCustomerExit(String id)throws SQLException, ClassNotFoundException;
}
