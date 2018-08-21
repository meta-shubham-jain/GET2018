import java.sql.Date;

/**
 * This class stores details of order with their order id , date and order total
 * 
 * @author Shubham Jain
 *
 */
public class OrderDetails {
    private int orderId;
    private Date orderDate;
    private float orderTotal;

    public OrderDetails(int orderId, Date orderDate, float orderTotal) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.orderTotal = orderTotal;
    }

    /**
     * Returns Order Id of Order
     * 
     * @return
     */
    public int getOrderId() {
        return orderId;
    }

    /**
     * Returns Date of Order
     * 
     * @return
     */
    public Date getDate() {
        return orderDate;
    }

    /**
     * Returns order Total Price
     * 
     * @return
     */
    public float getOrderTotal() {
        return orderTotal;
    }
}