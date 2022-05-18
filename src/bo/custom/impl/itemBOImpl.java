package bo.custom.impl;

import bo.custom.itemBO;
import dto.itemDTO;

import java.sql.SQLException;

public class itemBOImpl implements itemBO {
    @Override
    public boolean addItem(itemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean updateItem(itemDTO itemDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean ifItemExit(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
