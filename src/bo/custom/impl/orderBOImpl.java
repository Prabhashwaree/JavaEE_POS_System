package bo.custom.impl;

import bo.custom.orderBO;
import dao.DAOFactory;
import dao.custom.impl.orderDAOImpl;
import entity.order;

import javax.json.JsonArrayBuilder;
import java.sql.SQLException;

public class orderBOImpl implements orderBO {

    orderDAOImpl orderDAO = (orderDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);

    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewOrderId();

    }

    @Override
    public JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException {
        return orderDAO.getAll();
    }

    @Override
    public boolean placeOrder(order t) throws SQLException, ClassNotFoundException {
        order  o = new order(t.getOrderID(),t.getOrderDate(),t.getOrderTime(),t.getCustID());
        return orderDAO.add(o);
    }

}
