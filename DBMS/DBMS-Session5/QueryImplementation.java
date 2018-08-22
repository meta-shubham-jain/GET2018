import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

/**
 * This class will execute SQL queries and output the result
 * 
 * @author Shubham Jain
 *
 */
public class QueryImplementation {
    private Queries queryObject = new Queries();
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rset;

    /**
     * Connecting to database
     */
    QueryImplementation() {
        conn = ConnectionToDatabase.getConnection();
    }

    /**
     * This class will return all orders (Id, Order Date, Order Total) of the
     * user which are in shipped state.
     * 
     * @param userId
     * @return
     * @throws Exception
     */
    public List<OrderDetails> query1(int userId) throws Exception {
        if (userId < 1) {
            throw new Exception("User Id Should be greater than zero");
        }
        if (!validateUser(userId)) {
            throw new Exception("User Id doesnot exists");
        }
        List<OrderDetails> listOfOrder = new ArrayList<>();
        String query = queryObject.getQuery1(userId);
        try {
            stmt = (PreparedStatement) conn
                    .prepareStatement(query);
            rset = stmt.executeQuery();
            while (rset.next()) {
                int orderId = rset.getInt("order_id");
                Date orderDate = rset.getDate("date_of_order");
                float orderTotal = rset.getFloat("total_price");
                OrderDetails order = new OrderDetails(orderId, orderDate,
                        orderTotal);
                listOfOrder.add(order);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listOfOrder;
    }

    /**
     * It will return the count of tuples inserted in database. Inserting Images
     * of a product using batch insert technique.
     * 
     * @param imageList
     * @return
     * @throws SQLException
     */
    public int query2(List<Image> imageList) {
        String query = queryObject.getQuery2();
        int result = 0;
        try {
             stmt = (PreparedStatement) conn
                    .prepareStatement(query);
            conn.setAutoCommit(false);
            try {
                for (int i = 0; i < imageList.size(); i++) {
                    stmt.setString(1, imageList.get(i).getImage());
                    stmt.setInt(2, imageList.get(i).getProductId());
                    stmt.addBatch();
                }
                result = stmt.executeBatch().length;
                conn.commit();
            } catch (SQLException ex) {
                ex.printStackTrace();
                conn.rollback();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * Update product status to InActive for those products which were not
     * ordered by any Shopper in last 1 year. Return the number of products
     * Updated
     * 
     * @return
     */
    public int query3() {
        String query = queryObject.getQuery3();
        int result = 0;
        try {
           stmt = (PreparedStatement) conn
                    .prepareStatement(query);
           result = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * It will return list with category title of all top parent categories
     * sorted alphabetically and the count of their child categories.
     * 
     * @return
     */
    public List<ParentCategory> query4() {
        List<ParentCategory> listOfTopCategory = new ArrayList<>();
        String query = queryObject.getQuery4();
        try {
            stmt = (PreparedStatement) conn
                    .prepareStatement(query);
            rset = stmt.executeQuery();
            while (rset.next()) {
                String categoryTitle = rset.getString("category_name");
                int countOfChild = rset.getInt("count_of_child_category");
                ParentCategory parent = new ParentCategory(categoryTitle,
                        countOfChild);
                listOfTopCategory.add(parent);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listOfTopCategory;
    }

    /**
     * It will close the connection to database
     */
    public void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * It will check whether user exists or not
     * @param userId
     * @return true if user exists otherwise false
     */
    private boolean validateUser(int userId) {
        String query = "SELECT shopper_id FROM shopper"
                + " WHERE shopper_id = " + userId;
        try {
            stmt = (PreparedStatement) conn
                    .prepareStatement(query);
            rset = stmt.executeQuery();
            rset.last();
            int rows = rset.getRow();
            rset.beforeFirst();
            if (rows == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}