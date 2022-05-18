package bo.custom;

import bo.superBO;
import dto.itemDTO;

import javax.json.JsonArrayBuilder;
import java.sql.SQLException;

public interface itemBO extends superBO {

    JsonArrayBuilder getAllItem() throws SQLException, ClassNotFoundException;

    boolean addItem(itemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean updateItem(itemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    boolean ifItemExit(String id)throws SQLException, ClassNotFoundException;
}
