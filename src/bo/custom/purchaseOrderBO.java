package bo.custom;

import bo.superBO;
import dto.customerDTO;
import dto.itemDTO;
import dto.orderDTO;

import java.sql.SQLException;

public interface purchaseOrderBO extends superBO {
    boolean purchaseOrder(orderDTO dto) throws SQLException, ClassNotFoundException;

    String generateNewOrderId()throws SQLException, ClassNotFoundException;

//    ArrayList<customerDTO> getAllCustomer()throws SQLException, ClassNotFoundException;

//    ArrayList<itemDTO> getAllItem()throws SQLException, ClassNotFoundException;

    itemDTO searchItem(String code)throws SQLException, ClassNotFoundException;

    customerDTO searchCustomer(String s)throws SQLException, ClassNotFoundException;
}
