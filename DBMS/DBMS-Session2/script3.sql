USE store_front;

#Display Recent 50 Orders placed (Id, Order Date, Order Total).
SELECT order_id, shopper_id, date_of_order, total_price 
FROM order_details 
ORDER BY date_of_order 
DESC LIMIT 50;

#Display 10 most expensive Orders.
SELECT order_id, shopper_id, date_of_order, total_price 
FROM order_details 
ORDER BY total_price 
DESC LIMIT 10;

#Display all the Orders which are placed more than 10 days old and one or more items from 
#those orders are still not shipped.
SELECT o.order_id, shopper_id 
FROM order_details o, ordered_product p 
WHERE date_of_order <= DATE_SUB(NOW(),INTERVAL 10 DAY) 
AND order_status = "Not Shipped" AND o.order_id = p.order_id;

#Display list of shoppers which haven't ordered anything since last month.
SELECT shopper_id, CONCAT(shopper_first_name, ' ', shopper_last_name) AS Name
FROM shopper WHERE shopper_id NOT IN
(SELECT shopper_id FROM order_details
WHERE date_of_order >= DATE_SUB(NOW(),INTERVAL 1 MONTH));

#Display list of shopper along with orders placed by them in last 15 days. 
SELECT s.shopper_id, o.order_id, o.date_of_order, CONCAT(shopper_first_name, ' ', shopper_last_name) AS Name
FROM shopper s, order_details o 
WHERE date_of_order >= DATE_SUB(NOW(),INTERVAL 15 DAY) 
AND s.shopper_id = o.shopper_id;

#Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020))
SELECT order_id, product_id 
FROM ordered_product 
WHERE order_status = "Shipped" 
AND order_id = 3;

#Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.
SELECT o.order_id, o.product_id, product_name, date_of_order, p.product_price 
FROM ordered_product o 
INNER JOIN order_details s INNER JOIN product p 
ON o.order_id = s.order_id AND o.product_id = p.product_id AND p.product_price 
BETWEEN 20 AND 50;

#Update first 20 Order items status to “Shipped” which are placed today.
UPDATE ordered_product SET order_status = "Shipped" 
WHERE order_id IN 
            (SELECT order_id FROM order_details WHERE date_of_order = CURDATE() ORDER BY date_of_order)
LIMIT 20;