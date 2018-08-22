#Display Shopper’s information along with number of orders he/she placed during last 30 days.
SELECT s.shopper_id, CONCAT(shopper_first_name, ' ', shopper_last_name) AS Name, COUNT(order_id) AS Number_Of_Orders
FROM shopper s 
INNER JOIN order_details o ON s.shopper_id = o.shopper_id
WHERE o.date_of_order >= DATE_SUB(NOW(),INTERVAL 30 DAY)
GROUP BY o.shopper_id;

#Display the top 10 Shoppers who generated maximum number of revenue in last 30 days.
SELECT s.shopper_id, CONCAT(shopper_first_name, ' ', shopper_last_name) AS Name, SUM(total_price) AS Total_Price
FROM shopper s INNER JOIN order_details o
ON s.shopper_id = o.shopper_id
AND date_of_order >= DATE_SUB(NOW(),INTERVAL 30 DAY)
GROUP BY o.shopper_id
ORDER BY Total_Price DESC
LIMIT 10;

#Display top 20 Products which are ordered most in last 60 days along with numbers.
SELECT p.product_id, p.product_name, SUM(o.quantity) AS Number_of_Quantity
FROM product p, order_details d, ordered_product o
WHERE o.product_id = p.product_id 
AND o.order_id = d.order_id
AND d.date_of_order >= DATE_SUB(NOW(),INTERVAL 60 DAY)
GROUP BY o.product_id
ORDER BY Number_of_Quantity DESC
LIMIT 20;


#Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.
SELECT (CASE 
        WHEN date_of_order>=DATE_SUB(NOW(), INTERVAL DAY(CURDATE()) DAY) THEN MONTH(CURDATE())
        WHEN date_of_order>=DATE_SUB(DATE_SUB(NOW(), INTERVAL DAY(CURDATE()) DAY),INTERVAL 1 MONTH) THEN (MONTH(CURDATE()) -1)
        ELSE MONTH(CURDATE()) -2
        END
        ) AS MONTH, SUM(total_price) AS Total_Revenue
FROM order_details
WHERE date_of_order >= DATE_SUB(DATE_SUB(NOW(), INTERVAL DAY(CURDATE()) DAY), INTERVAL 2 MONTH) 
GROUP BY MONTH;

#Mark the products as Inactive which are not ordered in last 90 days.
UPDATE product 
SET product_status = 'Inactive'
WHERE product_id NOT IN (
                    SELECT product_id FROM order_details d, ordered_product o
                    WHERE o.order_id = d.order_id 
                    AND date_of_order >= DATE_SUB(NOW(), INTERVAL 90 DAY)
                    );

#Display top 10 Items which were cancelled most.
SELECT p.product_id, p.product_name, COUNT(o.product_id) AS Number_Of_Items_Canceled
FROM product p, ordered_product o
WHERE p.product_id = o.product_id
AND order_status = 'Cancel'
GROUP BY o.product_id
ORDER BY Number_Of_Items_Canceled DESC
LIMIT 10;