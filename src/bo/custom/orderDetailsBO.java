package bo.custom;

import bo.superBO;
import dto.orderDetailsDTO;

import javax.json.JsonArrayBuilder;
import java.sql.SQLException;

public interface orderDetailsBO extends superBO {
    JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException;
}
