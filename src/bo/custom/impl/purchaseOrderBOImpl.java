package bo.custom.impl;

import bo.custom.purchaseOrderBO;
import dto.customerDTO;
import dto.itemDTO;
import dto.orderDTO;

import java.sql.SQLException;

public class purchaseOrderBOImpl implements purchaseOrderBO {
    @Override
    public boolean purchaseOrder(orderDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public itemDTO searchItem(String code) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public customerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException {
        return null;
    }
}
