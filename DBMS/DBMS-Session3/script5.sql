#Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, Orderdate, Status) 
#with latest ordered items should be displayed first for last 60 days.

CREATE VIEW customer_orders 
AS 
SELECT o.order_id, product_name,o.total_price, CONCAT(shopper_first_name, ' ', shopper_last_name) AS Name,
shopper_email_id, date_of_order, order_status
FROM shopper s, product p, order_details d, ordered_product o
WHERE s.shopper_id = d.shopper_id
AND p.product_id = o.product_id
AND o.order_id = d.order_id
AND date_of_order >= DATE_SUB(NOW(),INTERVAL 60 DAY)
ORDER BY date_of_order DESC;

#Use the above view to display the Products(Items) which are in ‘shipped’ state.
SELECT order_id, product_name
FROM customer_orders
WHERE order_status = 'Shipped';

#Use the above view to display the top 5 most selling products.
SELECT product_name, COUNT(product_name) AS Number_Of_Product_Sold
FROM customer_orders
GROUP BY product_name
ORDER BY Number_Of_Product_Sold DESC
LIMIT 5;