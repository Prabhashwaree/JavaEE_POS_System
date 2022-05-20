package bo.custom.impl;

import bo.custom.orderDetailsBO;
import dao.DAOFactory;
import dao.custom.impl.orderDetailsDAOImpl;

import javax.json.JsonArrayBuilder;
import java.sql.SQLException;

public class orderDetailsBOImpl implements orderDetailsBO {

    orderDetailsDAOImpl orderDetailsDAO = (orderDetailsDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);

    @Override
    public JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException {
        return orderDetailsDAO.getAll();
    }
}
