USE store_front;

#Insert data into shopper
INSERT INTO shopper(shopper_first_name, shopper_last_name, shopper_email_id, date_of_birth, password, sex)
VALUES
    ("Shubham", "Jain", "jain33580@gmail.com", '1994-08-22', "123",'M'),
    ("Rahul", "Jain", "rahul@gmail.com", '1995-06-02', "123",'M'),
    ("Mohit", "Jain", "mohit@gmail.com", '1996-04-12', "123",'M'),
    ("Shyam", "Agarwal", "shyam@gmail.com", "1997-02-22", "321",'M'),
    ("Somi", "Vishnoi", "somi@gmail.com", "1996-01-22", "321",'F');

#Insert data into admin
INSERT INTO admin(admin_first_name, admin_last_name, admin_email_id, date_of_birth, password,sex)
VALUES
    ("Ravi", "Sharma", "ravi33580@gmail.com", '1994-08-22', "123",'M'),
    ("Raj", "Agarwal", "raj@gmail.com", '1995-06-02', "123",'M');

#Insert data into category
INSERT INTO category(parent_id, category_name)
VALUES
    (NULL, "Electronic_Gadgets"),
    (NULL, "Clothing"),
    (NULL, "Footwear"),
    (1, "Laptops"),
    (1, "Cameras"),
    (1, "Mobiles"),
    (2, "Mens_Wear"),
    (2, "Womens_Wear"),
    (2, "Kids_Wear"),
    (3, "Slippers"),
    (3, "Shoes"),
    (7, "Jeans"),
    (7, "Shirt"),
    (8, "Sarees"),
    (8, "Topper"),
    (8, "Kurtis"),
    (9, "Jackets"),
    (9, "Dresses"),
    (1,"Electronic_Accesories");


#Insert data into product
INSERT INTO product(product_issue_date, product_price, product_description,quantity, product_name )          
VALUES
   ('2018-01-01', 3000,"Comfortable, Smart", 20, "SportShoes"),
   ('2018-01-02', 2000,"Flat Sole, Shimmering", 500, "SneakersShoes"),
   ('2018-01-03', 50,"1 year warranty, Daily wear", 10, "FlatsSlippers"),
   ('2018-01-04', 2000,"Blue Color, Denim", 30, "LevisJeans"),
   ('2018-01-05', 4000,"Black color, Ankle", 200, "WoodlandJeans"),
   ('2018-01-06', 100,"White color, Round neck", 3000, "AdidasShirt"),
   ('2018-01-07', 1500,"Black color, Party wear", 20, "ReebokShirt"),
   ('2018-01-08', 5000,"Beautiful, Red color, Limited stock", 150, "SilkSaree"),
   ('2018-01-09', 7000,"Green color, Party wear, Light weight", 40, "CheffonSaree"),
   ('2018-01-10', 200,"Free length, Blue color", 0, "CottonSaree"),
   ('2018-01-11', 2500,"Purple color, Off shoulder", 30, "PeopleTop"),
   ('2018-01-12', 1500,"Black color, Striped", 120, "MaxTop"),
   ('2018-01-13', 2000,"Floor length", 600, "AnarkaliKurti"),
   ('2018-01-14', 130,"Parrot green color", 0, "ShortKurtis"),
   ('2018-01-15', 500,"Woollen, Red black color", 1100, "LittleJackets"),
   ('2018-01-16', 3000,"Half sleeves, comfortable, woollen", 70, "JiniJackets"),                 
   ('2018-01-17', 2000,"Beautiful, Dress, pink color", 200, "GirlsDress"),
   ('2018-01-18', 150,"Smart shirt and pant pair, Tie", 10, "BoysDress"),
   ('2018-01-19', 47000,"15Inch display, Black", 1700, "LenovoLaptop"),
   ('2018-01-20', 70000,"I7 processor, Graphic card", 20, "DellLaptop"),
   ('2018-01-21', 50000,"Red color, 8GB RAM", 40, "SamsungLaptop"),
   ('2018-01-22', 65000,"Small skirt for kids, top", 70, "SkirtDress"),
   ('2018-01-23', 1700,"Slim, Light weight, Rose gold color", 220, "LenovoMobile"),
   ('2018-01-24', 25000,"40 MP front caera, 4GB RAM", 410, "MIMobile");

#Insert data into categorized
INSERT INTO categorized(product_id,category_id)
VALUES
    (1,7),
    (2,11),
    (3,10),
    (4,12),
    (5,12),
    (6,13),
    (7,13),
    (8,14),
    (9,14),
    (10,14),
    (11,15),
    (12,15),
    (13,16),
    (14,16),
    (15,17),
    (16,17),
    (17,18),
    (18,18),
    (19,4),
    (20,4),
    (21,4),
    (22,5),
    (23,6),
    (24,6),
    (19,19),
    (20,19),
    (21,19);
    
#Insert data into images    
INSERT INTO images(product_id, image_url)
VALUES
    (1, "ShoesImg.jpg"),
    (1, "ShoesBack.jpg"),
    (3, "FlatSlipper.jpg"),
    (4, "JeansFront.png"),
    (4, "JeansBack.jpg"),
    (6, "AdidasShirtFront.jpg"),
    (6, "AdidasShirtBack.jpg"),
    (7, "ReebokFront.jpg"),
    (8, "SareeFront.jpg"),
    (8, "SareeSideView.jpg"),
    (9, "CheffonSaree.jpg"),
    (11, "PeopleTopFront.jpg"),
    (11, "PeopleTopBack.jpg"),
    (12, "MaxTop.jpg"),
    (13, "Kurtis.jpg"),
    (15, "JacketFront.jpg"),
    (15, "JacketBack.jpg"),
    (17, "GirlsDress.jpg"),
    (17, "Frock.jpg"),
    (18, "BoysDress.jpg"),
    (19, "ShortSkirtDress.jpg"),
    (19, "LongSkirtDress.jpg");
    

#Insert data into address    
INSERT INTO address(house_no,street_no,phone_no,shopper_id,pincode)
VALUES
    ("1",1,8094011142,1,"332001"),
    ("2",1,7725962262,1,"342001"),
    ("3",3,1234567890,2,"323001"),
    ("1",5,9876543210,3,"321001"),
    ("2",1,1357924680,4,"332010"),
    ("1",3,1234567890,5,"332110");

#Insert data into order_details
INSERT INTO order_details(shopper_id,total_price,date_of_order,address_id)
VALUES 
    (1,2000,"2018-03-22",1),
    (2,3000,"2018-08-11",3),
    (3,4000,"2018-07-08",4),
    (4,5000,"2018-06-12",5),
    (5,10000,"2018-08-13",6),
    (1,2000,"2018-08-17",1),
    (5,50,"2018-05-22",6),
    (1,2000,"2018-05-22",1),
    (2,3000,"2018-06-11",3),
    (3,4000,"2018-07-09",4),
    (4,5000,"2018-07-12",5),
    (5,10000,"2018-06-23",6);


#Insert data into ordered_product
INSERT INTO ordered_product(order_id,product_id,total_price,quantity,order_status)
VALUES
    (1,2,2000,1,"Shipped"),
    (2,2,2000,1,"Shipped"),
    (2,15,1000,2,"Shipped"),
    (3,2,2000,1,"Shipped"),
    (3,13,2000,1,"Not Shipped"),
    (4,16,3000,1,"Cancel"),
    (4,17,2000,1,"Shipped"),
    (5,12,6000,4,"Shipped"),
    (6,2,2000,1,"Not Shipped"),
    (7,3,50,1,"Shipped"),
    (8,2,2000,1,"Shipped"),
    (9,2,2000,1,"Shipped"),
    (9,15,1000,2,"Shipped"),
    (10,2,2000,1,"Not Shipped"),
    (10,13,2000,1,"Not Shipped"),
    (11,16,3000,1,"Cancel"),
    (11,17,2000,1,"Cancel"),
    (12,12,6000,4,"Cancel");

#Display Id, Title, category Title, Price of the products which are Active 
#and recently added products should be at top.
SELECT product.product_id,product_name,category_name,product_price 
FROM product,category,categorized 
WHERE product.product_id = categorized.product_id 
AND categorized.category_id = category.category_id
AND quantity > 0 
ORDER BY product_issue_date DESC;

#Display the list of products which don't have any images.
SELECT product_id, product_name 
FROM product 
WHERE product_id NOT IN 
                    (SELECT product_id from images);

#Display all Id, Title and Parent category Title for all the Categories listed, sorted by Parent category 
#Title and then category Title. (If category is top category then Parent category Title column should display 
#“Top category” as value.)
SELECT c.category_id, c.category_name, IFNULL(p.category_name, "Top category") AS Parentcategory
FROM category c LEFT JOIN  category p
ON c.parent_id = p.category_id
ORDER BY p.category_name, c.category_name;

#Display Id, Title, Parent category Title of all the leaf Categories 
#(categories which are not parent of any other category)
SELECT r.category_id, r.category_name, IFNULL(l.category_name, "Top category") AS Parentcategory
FROM category r LEFT JOIN category l
ON r.parent_id = l.category_id
WHERE r.category_id NOT IN 
                        (SELECT DISTINCT c.category_id 
                         FROM category c 
                         INNER JOIN category p 
                         ON c.category_id = p.parent_id
                         );

#Display product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)
SELECT p.product_name, p.product_price, p.product_description 
FROM product p, category c, categorized z
WHERE p.product_id = z.product_id 
AND c.category_id = z.category_id 
AND c.category_name = "Mobiles";

#Display the list of products whose Quantity on hand (Inventory) is under 50.
SELECT product_name 
FROM product 
WHERE quantity <=50;

#Increase the Inventory of all the products by 100.
UPDATE product 
SET quantity = quantity + 100;