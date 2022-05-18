package bo.custom.impl;

import bo.custom.orderDetailsBO;
import dto.orderDetailsDTO;

import java.sql.SQLException;

public class orderDetailsBOImpl implements orderDetailsBO {
    @Override
    public boolean updateOrderDetail(orderDetailsDTO itemDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
