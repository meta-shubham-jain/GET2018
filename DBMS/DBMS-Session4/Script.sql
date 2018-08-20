#DBMS Session 4 Assignment
USE store_front;

#Create a function to calculate number of orders in a month.
#Month and year will be input parameter to function.
DELIMITER $$
CREATE FUNCTION no_of_orders(month INT, year INT) RETURNS INT
        BEGIN
          DECLARE count_of_orders INT;
          SELECT COUNT(order_id) INTO count_of_orders
            FROM order_details
            WHERE month = MONTH(date_of_order)
            AND year = YEAR(date_of_order)
            GROUP BY month; 
            RETURN no_of_orders;
        END$$
DELIMITER ;

SELECT NoOfOrders(08,2018);

#Create a function to return month in a year having maximum orders. Year will be input parameter.
DELIMITER $$
CREATE FUNCTION month_number(year INT) RETURNS INT
    BEGIN 
        DECLARE month INT;
        SELECT month_number INTO month
        FROM 
            (SELECT Count(order_id) AS count_id , MONTH(date_of_order) AS month_number 
             FROM order_details
             WHERE year = YEAR(date_of_order)
             GROUP BY MONTH(date_of_order)
             ORDER BY count_id DESC) order_in_month
        LIMIT 1;
        RETURN month;
    END$$
DELIMITER ;

SELECT month_number(2018);

#Create a Stored procedure to retrieve average sales of each product in a month. 
#Month and year will be input parameter to function.

DELIMITER $$
CREATE PROCEDURE average_sales(month INT, year INT)
    BEGIN
        SELECT AVG(o.total_price) AS average_sales, product_id 
        FROM order_details d, ordered_product o
        WHERE d.order_id = o.order_id
        AND year = YEAR(date_of_order)
        AND month = MONTH(date_of_order)
        GROUP BY product_id;
    END$$
DELIMITER $$;

CALL average_sales(08,2018);

#Create a stored procedure to retrieve table having order detail with status for a given period. 
#Start date and end date will be input parameter. Put validation on input dates like start 
#date is less than end date. If start date is greater than end date take first date of month as start date.

DELIMITER $$
CREATE FUNCTION date_validation(start_date DATE, end_date DATE) RETURNS DATE
        BEGIN
            IF start_date < end_date
                THEN RETURN start_date;
            ELSE
                RETURN DATE_FORMAT(end_date ,'%Y-%m-01');
            END IF;
        END$$
                    
DELIMITER $$
CREATE PROCEDURE order_between_dates(start_date DATE , end_date DATE)
        BEGIN
            SET start_date = date_validation(start_date,end_date);
            SELECT d.order_id, o.product_id, o.order_status
            FROM order_details d, ordered_product o
            WHERE o.order_id = d.order_id
            AND date_of_order > start_date
            AND date_of_order < end_date;
        END$$
DELIMITER ;

CALL order_between_dates('2018-08-01','2018-08-20'); 

#Identify the columns require indexing in order, product, category tables and create indexes.
ALTER TABLE product ADD INDEX index_on_product_id(product_id);
ALTER TABLE product  ADD FULLTEXT index_on_product_name(product_name) ;

ALTER TABLE category ADD INDEX index_on_category_id(category_id);
ALTER TABLE category ADD FULLTEXT index_on_category_name(category_name);
ALTER TABLE category ADD UNIQUE index_on_parent_id(parent_id);

ALTER TABLE order_details ADD INDEX index_on_order_id(order_id);
ALTER TABLE order_details ADD INDEX index_on_date_of_order(date_of_order);



           
           
           




