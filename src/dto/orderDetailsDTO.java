package dto;

public class orderDetailsDTO {
    private String OrderID;
    private String ItemCode;
    private double Orderqty;
    private String Discount;
    private String Balance;

    public orderDetailsDTO() {
    }

    public orderDetailsDTO(String orderID, String itemCode, double orderqty, String discount, String balance) {
        setOrderID(orderID);
        setItemCode(itemCode);
        setOrderqty(orderqty);
        setDiscount(discount);
        setBalance(balance);
    }

    public String getOrderID() {
        return OrderID;
    }

    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public double getOrderqty() {
        return Orderqty;
    }

    public void setOrderqty(double orderqty) {
        Orderqty = orderqty;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    @Override
    public String toString() {
        return "orderDetailsDTO{" +
                "OrderID='" + OrderID + '\'' +
                ", ItemCode='" + ItemCode + '\'' +
                ", Orderqty=" + Orderqty +
                ", Discount='" + Discount + '\'' +
                ", Balance='" + Balance + '\'' +
                '}';
    }
}
