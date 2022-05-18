package bo.custom;

import bo.superBO;
import dto.orderDetailsDTO;

import java.sql.SQLException;

public interface orderDetailsBO extends superBO {
//    ObservableList<OrderDetailsTm> getAllOrderDetail()throws SQLException, ClassNotFoundException;

    boolean updateOrderDetail(orderDetailsDTO itemDTO) throws SQLException, ClassNotFoundException;

    boolean deleteOrderDetail(String id) throws SQLException, ClassNotFoundException;

}
