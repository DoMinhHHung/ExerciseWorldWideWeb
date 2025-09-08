package fit.iuh.se.bai04_JSP_Session.model;

import lombok.Data;

@Data
public class CartItemBean {
    private String strPartNumber;
    private String modelDescription;
    private double unitCost;
    private int iQuantity;
    private double totalCost;
}
