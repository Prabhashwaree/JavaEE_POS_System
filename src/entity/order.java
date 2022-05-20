package entity;

import dto.orderDetailsDTO;

import java.util.ArrayList;

public class order {
    private String orderID;
    private String orderDate;
    private double orderTime;
    private String custID;

    private ArrayList<orderDetailsDTO> arrayList;

    public order() {
    }

    public order(String orderID, String orderDate, double orderTime, String custID, ArrayList<orderDetailsDTO> arrayList) {
        this.setOrderID(orderID);
        this.setOrderDate(orderDate);
        this.setOrderTime(orderTime);
        this.setCustID(custID);
        this.setArrayList(arrayList);
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public double getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(double orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public ArrayList<orderDetailsDTO> getArrayList() {
        return arrayList;
    }

    public void setArrayList(ArrayList<orderDetailsDTO> arrayList) {
        this.arrayList = arrayList;
    }
}
