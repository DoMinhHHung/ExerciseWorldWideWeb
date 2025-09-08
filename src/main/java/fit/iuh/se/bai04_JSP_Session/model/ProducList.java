package fit.iuh.se.bai04_JSP_Session.model;

import java.util.ArrayList;
import java.util.List;

public class ProducList {
    private static final List<Product> ds = new ArrayList<Product>();
    static {
        initData();
    }

    public static List<Product> queryProduct() {
        return ds;
    }

    private static void initData() {
        Product sp1 = new Product();
        sp1.setId("PRO01");
        sp1.setModel("Nokia Lumia");
        sp1.setDescription("High quality smartphone");
        sp1.setPrice(99000);
        sp1.setQuantity(10);
        sp1.setImgURL("https://via.placeholder.com/80x100");
        ds.add(sp1);

        Product sp2 = new Product();
        sp2.setId("PRO02");
        sp2.setModel("BlackBerry Passport");
        sp2.setDescription("Business smartphone");
        sp2.setPrice(49000);
        sp2.setQuantity(10);
        sp2.setImgURL("https://via.placeholder.com/80x100");
        ds.add(sp2);

        Product sp3 = new Product();
        sp3.setId("PRO03");
        sp3.setModel("Sony Xperia Z5");
        sp3.setDescription("Waterproof smartphone");
        sp3.setPrice(52000);
        sp3.setQuantity(10);
        sp3.setImgURL("https://via.placeholder.com/80x100");
        ds.add(sp3);

        Product sp4 = new Product();
        sp4.setId("PRO04");
        sp4.setModel("HTC One M9");
        sp4.setDescription("Premium smartphone");
        sp4.setPrice(83000);
        sp4.setQuantity(10);
        sp4.setImgURL("https://via.placeholder.com/80x100");
        ds.add(sp4);

        Product sp5 = new Product();
        sp5.setId("PRO05");
        sp5.setModel("Samsung Galaxy Note 5");
        sp5.setDescription("Stylus smartphone");
        sp5.setPrice(71000);
        sp5.setQuantity(10);
        sp5.setImgURL("https://via.placeholder.com/80x100");
        ds.add(sp5);
    }
}
