package dto;

public class orderDTO {
    private String OrderID;
    private String OrderDate;
    private double OrderTime;
    private String CustID;

    public orderDTO() {
    }

    public orderDTO(String orderID, String orderDate, double orderTime, String custID) {
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

    @Override
    public String toString() {
        return "orderDTO{" +
                "OrderID='" + OrderID + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                ", OrderTime=" + OrderTime +
                ", CustID='" + CustID + '\'' +
                '}';
    }
}
