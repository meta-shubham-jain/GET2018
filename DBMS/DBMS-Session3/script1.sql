CREATE DATABASE store_front;
USE store_front;

CREATE TABLE shopper(
             shopper_id INT AUTO_INCREMENT, 
             shopper_first_name VARCHAR(50) NOT NULL, 
             shopper_last_name VARCHAR(50) NOT NULL, 
             shopper_email_id VARCHAR(50) NOT NULL UNIQUE, 
             date_of_birth DATE NOT NULL, 
             password VARCHAR(50) NOT NULL,
             sex CHAR(1) CHECK(sex IN ('M','F')),
             PRIMARY KEY(shopper_id)
 );
             
CREATE TABLE admin(
             admin_id INT AUTO_INCREMENT, 
             admin_first_name VARCHAR(50) NOT NULL, 
             admin_last_name VARCHAR(50) NOT NULL, 
             admin_email_id VARCHAR(50) NOT NULL UNIQUE, 
             date_of_birth DATE NOT NULL, 
             password VARCHAR(50) NOT NULL, 
             sex CHAR(1) CHECK(sex IN ('M','F')),
             PRIMARY KEY(admin_id)
 );

CREATE TABLE state(
             state_name VARCHAR(20),
             PRIMARY KEY(state_name)
             );

CREATE TABLE city(
             city_name VARCHAR(20),
             state_name VARCHAR(20) NOT NULL,
             PRIMARY KEY(city_name),
             FOREIGN KEY(state_name) REFERENCES state(state_name)
             );

CREATE TABLE zip_code(
             pincode VARCHAR(10),
             city_name VARCHAR(20) NOT NULL,
             area_name VARCHAR(20) NOT NULL,
             PRIMARY KEY(pincode),
             FOREIGN KEY(city_name) REFERENCES city(city_name)
             );
             
CREATE TABLE address(
             address_id INT AUTO_INCREMENT, 
             house_no VARCHAR(10), 
             street_no INT, 
             phone_no VARCHAR(12), 
             shopper_id INT,
             pincode VARCHAR(10) NOT NULL, 
             PRIMARY KEY(address_id),
             FOREIGN KEY(shopper_id) REFERENCES shopper(shopper_id),
             FOREIGN KEY(pincode) REFERENCES zip_code(pincode)
 );

CREATE TABLE product(
             product_id INT AUTO_INCREMENT, 
             product_name VARCHAR(50) NOT NULL,
             product_price FLOAT(2) NOT NULL, 
             quantity INT CHECK(quantity > 0),
             product_issue_date DATE NOT NULL,
             product_description VARCHAR(200),
             product_status VARCHAR(10) DEFAULT 'Active',
             PRIMARY KEY(product_id)
 );
 
CREATE TABLE category(
             category_id INT AUTO_INCREMENT, 
             category_name VARCHAR(50) NOT NULL, 
             parent_id INT,
             PRIMARY KEY(category_id), 
             FOREIGN KEY(parent_id) REFERENCES category(category_id)
 );
             
CREATE TABLE categorized(
             product_id INT, 
             category_id INT, 
             PRIMARY KEY(product_id,category_id),
             FOREIGN KEY(product_id) REFERENCES product(product_id), 
             FOREIGN KEY(category_id) REFERENCES category(category_id)
 );
             
CREATE TABLE images(
             image_url VARCHAR(50), 
             product_id INT, 
             PRIMARY KEY(image_url, product_id), 
             FOREIGN KEY(product_id) REFERENCES product(product_id)
 );
             
CREATE TABLE cart(
             product_id INT,
             shopper_id INT, 
             quantity INT,
             total_price FLOAT(2),
             PRIMARY KEY(product_id,shopper_id),
             FOREIGN KEY(product_id) REFERENCES product(product_id),
             FOREIGN KEY(shopper_id) REFERENCES shopper(shopper_id)
 );
             
CREATE TABLE order_details(
             order_id INT AUTO_INCREMENT, 
             shopper_id INT,
             total_price Float(2),
             date_of_order DATE,
             address_id INT,
             Primary KEY(order_id), 
             FOREIGN KEY(shopper_id) REFERENCES shopper(shopper_id),
             FOREIGN KEY(address_id) REFERENCES address(address_id)
 );
 
CREATE TABLE ordered_product(
             order_id INT,
             product_id INT, 
             total_price FLOAT(2), 
             quantity INT,
             order_status VARCHAR(20),
             PRIMARY KEY(order_id, product_id), 
             FOREIGN KEY(order_id) REFERENCES order_details(order_id),
             FOREIGN KEY(product_id) REFERENCES product(product_id)
 );
 
#Write a command to display all the table names present in StoreFront.
Show TABLES;

#Write a command to remove Product table of the StoreFront database.
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE product;
SET FOREIGN_KEY_CHECKS = 1;

#Create the Product table again.
CREATE TABLE product(
             product_id INT AUTO_INCREMENT, 
             product_name VARCHAR(50) NOT NULL, 
             product_price FLOAT(2) NOT NULL, 
             quantity INT, 
             product_issue_date DATE NOT NULL,
             product_description VARCHAR(200),
             product_status VARCHAR(10) DEFAULT 'Active',
             PRIMARY KEY(product_id)
 );