package bo.custom.impl;

import bo.custom.orderBO;
import dao.DAOFactory;
import dao.custom.impl.orderDAOImpl;
import dao.custom.impl.orderDetailsDAOImpl;
import dto.orderDTO;
import dto.orderDetailsDTO;
import entity.order;
import entity.orderDetails;
import servlet.orderServlet;

import javax.json.JsonArrayBuilder;
import java.sql.Connection;
import java.sql.SQLException;

public class orderBOImpl implements orderBO {

    orderDAOImpl orderDAO = (orderDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    orderDetailsDAOImpl orderDetailsDAO = (orderDetailsDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAIL);


    @Override
    public String generateNewOrderId() throws SQLException, ClassNotFoundException {
        return orderDAO.generateNewOrderId();

    }

    @Override
    public JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException {
        return orderDAO.getAll();
    }

    @Override
    public boolean placeOrder(orderDTO t) throws SQLException, ClassNotFoundException {
        Connection connection = orderServlet.dataSource.getConnection();

        connection.setAutoCommit(false);
        order o = new  order(t.getOrderID(),t.getOrderDate(),t.getOrderTime(),t.getCustID(),t.getOrderDetailsDTOS());
        boolean b = orderDAO.add(o);

        if(!b){
            connection.rollback();
            connection.setAutoCommit(true);
            return false;
        }
        for (orderDetailsDTO temp:t.getOrderDetailsDTOS()){
            orderDetails orderDetails = new orderDetails(temp.getOrderID(),temp.getItemCode(),temp.getOrderqty(),temp.getDiscount(),temp.getBalance());
            boolean details = orderDetailsDAO.add(orderDetails);

            if(! details){
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }
        }
        connection.rollback();
        connection.setAutoCommit(true);
        return true;
    }

}
