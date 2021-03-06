package bo.custom;

import bo.superBO;
import dto.orderDTO;
import entity.order;

import javax.json.JsonArrayBuilder;
import java.sql.SQLException;

public interface orderBO extends superBO {
    String generateNewOrderId() throws SQLException, ClassNotFoundException;

    JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException;

    boolean placeOrder(orderDTO t) throws SQLException, ClassNotFoundException;
}
