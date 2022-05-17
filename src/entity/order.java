package entity;

public class order {
    private String OrderID;
    private String OrderDate;
    private double OrderTime;
    private String CustID;

    public order() {
    }

    public order(String orderID, String orderDate, double orderTime, String custID) {
        setOrderID(orderID);
        setOrderDate(orderDate);
        setOrderTime(orderTime);
        setCustID(custID);
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public double getOrderTime() {
        return OrderTime;
    }

    public void setOrderTime(double orderTime) {
        OrderTime = orderTime;
    }

    public String getCustID() {
        return CustID;
    }

    public void setCustID(String custID) {
        CustID = custID;
    }
}
