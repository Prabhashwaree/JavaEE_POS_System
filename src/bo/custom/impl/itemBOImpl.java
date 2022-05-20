package bo.custom.impl;

import bo.custom.itemBO;
import dao.DAOFactory;
import dao.custom.impl.itemDAOImpl;
import dto.itemDTO;
import entity.item;

import javax.json.JsonArrayBuilder;
import java.sql.SQLException;

public class itemBOImpl implements itemBO {

    private final itemDAOImpl itemDAOImpl = (itemDAOImpl) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);


    @Override
    public JsonArrayBuilder getAllItem() throws SQLException, ClassNotFoundException {
        return itemDAOImpl.getAll();
    }

    @Override
    public boolean addItem(itemDTO i) throws SQLException, ClassNotFoundException {
        item item = new item(i.getItemCode(),i.getItemName(),i.getPrice(),i.getQty());
        return itemDAOImpl.add(item);
    }

    @Override
    public boolean updateItem(itemDTO i) throws SQLException, ClassNotFoundException {
        item item = new item(i.getItemCode(),i.getItemName(),i.getPrice(),i.getQty());
        return itemDAOImpl.update(item);
    }

    @Override
    public boolean deleteItem(String id) throws SQLException, ClassNotFoundException {
        return itemDAOImpl.delete(id);
    }

}
