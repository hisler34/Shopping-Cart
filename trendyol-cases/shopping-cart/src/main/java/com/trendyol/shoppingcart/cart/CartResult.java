package com.trendyol.shoppingcart.cart;import com.trendyol.shoppingcart.category.CategoryComponent;import com.trendyol.shoppingcart.product.ProductComponent;import com.trendyol.shoppingcart.utilities.Utils;import lombok.*;import java.lang.reflect.Field;import java.util.Map;@Setter@Getterpublic class CartResult {    private double totalAmountAfterDiscount;    private double couponDiscount;    private Map<CategoryComponent, Map<ProductComponent,Integer>> groupedProductsByCategory;    private double totalPrice;    private double totalDiscountWithCampaign;    private double totalDiscountWithCoupon;    private double totalAmount;    private double deliveryCost;    public CartResult() {    }    public String toString() {        StringBuffer result = new StringBuffer();        String newLine = System.getProperty("line.separator");        result.append(this.getClass().getName());        result.append(" Shopping Cart Detail {");        result.append(newLine);        //determine fields declared in this class only (no fields of superclass)        Field[] fields = this.getClass().getDeclaredFields();        //print field names paired with their values        for (Field field : fields) {            result.append("  ");            try {                result.append(field.getName());                result.append(": ");                //requires access to private field:                result.append(field.get(this));            } catch (IllegalAccessException ex) {                System.out.println(ex);            }            result.append(newLine);        }        result.append("}");        return result.toString();    }    public String toZtring(){        return Utils.toZtring(this,"Shopping Cart Detail");    }}