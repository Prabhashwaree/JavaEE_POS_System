package dao.custom.impl;

import dao.custom.itemDAO;
import entity.item;
import servlet.customerServlet;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class itemDAOImpl implements itemDAO {


    @Override
    public boolean add(item i) throws SQLException, ClassNotFoundException {
        Connection connection = customerServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Item VALUES (?,?,?,?)");
        preparedStatement.setString(1,i.getItemCode());
        preparedStatement.setString(2,i.getItemName());
        preparedStatement.setDouble(3,i.getPrice());
        preparedStatement.setString(4,i.getQty());


        System.out.println(i.getItemCode());
        System.out.println(i.getItemName());
        System.out.println(i.getPrice());
        System.out.println(i.getQty());


        if(preparedStatement.executeUpdate()>0){
            connection.close();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        Connection connection = customerServlet.dataSource.getConnection();

        if(connection.prepareStatement("DELETE FROM Item WHERE ItemCode ='"+s+"'").executeUpdate()>0){
            connection.close();
            return true;

        }else {
            return false;
        }

    }

    @Override
    public boolean update(item i) throws SQLException, ClassNotFoundException {
        Connection connection = customerServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Item SET ItemName = ?,Price = ?,Qty = ? WHERE ItemCode = ?");
        preparedStatement.setString(1,i.getItemName());
        preparedStatement.setDouble(2,i.getPrice());
        preparedStatement.setString(3,i.getQty());
        preparedStatement.setString(4,i.getItemCode());

        if(preparedStatement.executeUpdate()>0){
            connection.close();
            return true;
        }else {
            return false;
        }
    }

    @Override
    public JsonObjectBuilder search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public JsonArrayBuilder getAll() throws SQLException, ClassNotFoundException {
        JsonArrayBuilder jsonArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();


        Connection connection = customerServlet.dataSource.getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Item");
        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {
            String itemCode = resultSet.getString(1);
            String itemName = resultSet.getString(2);
            double price = resultSet.getDouble(3);
            String qty = resultSet.getString(4);


            objectBuilder.add("itemCode", itemCode);
            objectBuilder.add("itemName", itemName);
            objectBuilder.add("price", price);
            objectBuilder.add("qty", qty);

            jsonArrayBuilder.add(objectBuilder.build());


        }
        connection.close();
        return jsonArrayBuilder;
    }
}
