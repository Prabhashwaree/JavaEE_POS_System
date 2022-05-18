package bo.custom;

import bo.superBO;
import dto.itemDTO;

import java.sql.SQLException;

public interface itemBO extends superBO {
//    ObservableList<itemTm> getAllItem()throws SQLException, ClassNotFoundException;

    boolean addItem(itemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean updateItem(itemDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String id) throws SQLException, ClassNotFoundException;

    boolean ifItemExit(String id)throws SQLException, ClassNotFoundException;
}
