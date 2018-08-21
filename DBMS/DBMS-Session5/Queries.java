/**
 * This class returns query of sql
 * 
 * @author Shubham Jain
 *
 */
public class Queries {

    /**
     * Given the id of a user, fetch all orders (Id, Order Date, Order Total) of
     * that user which are in shipped state. Orders should be sorted by order
     * date column in chronological order.
     * 
     * @param userId
     * @return String query
     */
    public String getQuery1(int userId) {
        String query = "SELECT o.order_id, date_of_order, SUM(o.total_price) AS total_price"
                + " FROM order_details d, ordered_product o"
                + " WHERE d.order_id = o.order_id"
                + " AND d.shopper_id ="
                + userId
                + " AND order_status = 'Shipped'"
                + " GROUP BY o.order_id" + " ORDER BY date_of_order";
        return query;
    }

    /**
     * Insert five or more images of a product using batch insert technique.
     * 
     * @return String query
     */
    public String getQuery2() {
        String query = "INSERT INTO images(image_url,product_id) VALUES (?,?)";
        return query;
    }

    /**
     * Update product status to Inactive for those products which were not
     * ordered by any Shopper in last 1 year. Return the number of products
     * deleted.
     * 
     * @return String query
     */
    public String getQuery3() {
        String query = "UPDATE product"
                + " SET product_status = 'InActive'"
                + " WHERE product_id NOT IN"
                + " (SELECT DISTINCT product_id FROM order_details d , ordered_product o"
                + " WHERE d.order_id = o.order_id"
                + " AND date_of_order >= DATE_SUB(NOW(), INTERVAL 1 YEAR)"
                + ")";
        return query;
    }

    /**
     * Select and display the category title of all top parent categories sorted
     * alphabetically and the count of their child categories.
     * 
     * @return String query
     */
    public String getQuery4() {
        String query = " SELECT c.category_name, COUNT(c.category_id) AS count_of_child_category"
                + " FROM category c, category p"
                + " WHERE c.category_id = p.parent_id"
                + " AND c.parent_id IS NULL"
                + " GROUP BY c.category_id"
                + " ORDER BY category_name";
        return query;
    }
}