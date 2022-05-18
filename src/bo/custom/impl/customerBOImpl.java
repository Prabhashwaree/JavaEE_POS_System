package bo.custom.impl;

import bo.custom.customerBO;
import dao.DAOFactory;
import dao.custom.customerDAO;
import dao.custom.impl.customerDAOImpl;
import dto.customerDTO;
import entity.customer;

import java.sql.SQLException;

public class customerBOImpl implements customerBO {
    private final customerDAOImpl cusDAOImpl = (customerDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(customerDTO c) throws SQLException, ClassNotFoundException {
        customer customer = new customer(c.getCustID(),c.getCustName(),c.getCustAddress(),c.getSalary());
        return cusDAOImpl.add(customer);

    }

    @Override
    public boolean updateCustomer(customerDTO customerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean ifCustomerExit(String id) throws SQLException, ClassNotFoundException {
        return false;
    }
}
