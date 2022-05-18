package bo;

import bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBOFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public superBO getBO(BoTypes types) {
        switch (types) {
            case CUSTOMER:
                return new customerBOImpl();
            case ITEM:
                return new itemBOImpl();
            case ORDER:
                return new orderBOImpl();
            case ORDERDETAIL:
                return new orderDetailsBOImpl();
            case PURCHASE_ORDER:
                return new purchaseOrderBOImpl();
            default:
                return null;
        }
    }

    public enum BoTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAIL, PURCHASE_ORDER
    }
}
