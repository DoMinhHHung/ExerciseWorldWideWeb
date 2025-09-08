package fit.iuh.se.bai04_JSP_Session.model;

import java.util.ArrayList;

public class CartBean {
    private ArrayList<CartItemBean> alCartItem = new ArrayList<CartItemBean>();
    private double dblOrderTotal;

    public int getLineItemCount() {
        return alCartItem.size();
    }

    public void deleteCartItem(String strItemIndex) {
        int iItemIndex = 0;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            alCartItem.remove(iItemIndex - 1);
            calculateOrderTotal();
        } catch (NumberFormatException nfe) {
            System.out.println("Error while delete cart item: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public void updateCartItem(String strItemIndex, String strQuantity) {
        double dblTotalCost = 0.0;
        double dblUnitCost = 0.0;
        int iQuantity = 0;
        int iItemIndex = 0;
        CartItemBean cartItem = null;
        try {
            iItemIndex = Integer.parseInt(strItemIndex);
            iQuantity = Integer.parseInt(strQuantity);
            if (iQuantity > 0) {
                cartItem = (CartItemBean) alCartItem.get(iItemIndex - 1);
                dblUnitCost = cartItem.getUnitCost();
                dblTotalCost = dblUnitCost * iQuantity;
                cartItem.setIQuantity(iQuantity);
                cartItem.setTotalCost(dblTotalCost);
                calculateOrderTotal();
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Error while update cart item: " + nfe.getMessage());
            nfe.printStackTrace();
        }
    }

    public CartItemBean getCartItem(int iItemIndex) {
        CartItemBean cartItem = null;
        if (alCartItem.size() > iItemIndex) {
            cartItem = (CartItemBean) alCartItem.get(iItemIndex);
        }
        return cartItem;
    }

    public ArrayList<CartItemBean> getCartItem() {
        return alCartItem;
    }

    public void setCartItem(ArrayList<CartItemBean> alCartItem) {
        this.alCartItem = alCartItem;
    }

    public double getOrderTotal() {
        return dblOrderTotal;
    }

    public void setOrderTotal(double dblOrderTotal) {
        this.dblOrderTotal = dblOrderTotal;
    }

    protected void calculateOrderTotal() {
        double dblTotal = 0.0;
        for (int counter = 0; counter < alCartItem.size(); counter++) {
            CartItemBean cartItem = (CartItemBean) alCartItem.get(counter);
            dblTotal += cartItem.getTotalCost();
        }
        setOrderTotal(dblTotal);
    }

    public void addCartItem(String strModelNo, String strDescription, String strUnitCost, String strQuantity) {
        double dblTotalCost = 0.0;
        double dblUnitCost = 0.0;
        int iQuantity = 0;
        CartItemBean cartItem = new CartItemBean();
        try {
            dblUnitCost = Double.parseDouble(strUnitCost);
            iQuantity = Integer.parseInt(strQuantity);
            if (iQuantity > 0) {
                dblTotalCost = dblUnitCost * iQuantity;
                cartItem.setStrPartNumber(strModelNo);
                cartItem.setModelDescription(strDescription);
                cartItem.setUnitCost(dblUnitCost); // Fixed: should be dblUnitCost, not dblTotalCost
                cartItem.setIQuantity(iQuantity);
                cartItem.setTotalCost(dblTotalCost);
                alCartItem.add(cartItem);
                calculateOrderTotal();
            }
        } catch (NumberFormatException e) {
            System.out.println("Error while adding cart item: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void addCartItem(CartItemBean cartItem) {
        alCartItem.add(cartItem);
    }
}
