package fit.iuh.se.bai04_JSP_Session.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String id;
    private String model;
    private String description;
    private int quantity;
    private double price;
    private String imgURL;
}
