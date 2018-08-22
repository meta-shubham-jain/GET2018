#Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories.
SELECT p.product_id, p.product_name, COUNT(category_id) AS count_of_categories
FROM product p INNER JOIN categorized c 
ON p.product_id = c.product_id
GROUP BY c.product_id
HAVING (count_of_categories > 1);

#Display Count of products as per below price range:
#Range in Rs.           Count
         #0 - 100
         #101 - 500
         #Above 500
SELECT ( CASE 
         WHEN product_price BETWEEN 0 and 100 THEN '0-100'
         WHEN product_price BETWEEN 101 and 500 THEN '101-500'
         WHEN product_price > 500 THEN 'Above 500'
         END 
         ) AS Range_In_Rs, COUNT(product_id) AS Count_Product
FROM product
GROUP BY Range_In_Rs;