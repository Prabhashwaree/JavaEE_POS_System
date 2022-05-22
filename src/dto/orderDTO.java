package dto;

import java.util.ArrayList;

public class orderDTO {
    private String orderID;
    private String orderDate;
    private String orderTime;
    private String custID;

    private ArrayList<orderDetailsDTO> orderDetailsDTOS;


    public orderDTO(String orderID, String orderDate, String orderTime, String custID, ArrayList<orderDetailsDTO> orderDetailsDTOS) {
        this.setOrderID(orderID);
        this.setOrderDate(orderDate);
        this.setOrderTime(orderTime);
        this.setCustID(custID);
        this.setOrderDetailsDTOS(orderDetailsDTOS);
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

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getCustID() {
        return custID;
    }

    public void setCustID(String custID) {
        this.custID = custID;
    }

    public ArrayList<orderDetailsDTO> getOrderDetailsDTOS() {
        return orderDetailsDTOS;
    }

    public void setOrderDetailsDTOS(ArrayList<orderDetailsDTO> orderDetailsDTOS) {
        this.orderDetailsDTOS = orderDetailsDTOS;
    }

    @Override
    public String toString() {
        return "orderDTO{" +
                "orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", orderTime='" + orderTime + '\'' +
                ", custID='" + custID + '\'' +
                ", arrayList=" + orderDetailsDTOS +
                '}';
    }
}
