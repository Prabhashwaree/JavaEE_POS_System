package dao;

import dao.custom.impl.customerDAOImpl;
import dao.custom.impl.itemDAOImpl;
import dao.custom.impl.orderDAOImpl;
import dao.custom.impl.orderDetailsDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public superDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new customerDAOImpl();
            case ITEM:
                return new itemDAOImpl();
            case ORDER:
                return new orderDAOImpl();
            case ORDERDETAIL:
                return new orderDetailsDAOImpl();
            default:
                return null;
        }
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAIL;
    }
}
