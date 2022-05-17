package dto;

public class itemDTO {
    private String ItemCode;
    private String ItemName;
    private double Price;
    private String Qty;

    public itemDTO() {
    }

    public itemDTO(String itemCode, String itemName, double price, String qty) {
        setItemCode(itemCode);
        setItemName(itemName);
        setPrice(price);
        setQty(qty);
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    @Override
    public String toString() {
        return "itemDTO{" +
                "ItemCode='" + ItemCode + '\'' +
                ", ItemName='" + ItemName + '\'' +
                ", Price=" + Price +
                ", Qty='" + Qty + '\'' +
                '}';
    }
}
