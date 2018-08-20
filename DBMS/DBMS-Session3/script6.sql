#DBMS Session 3 Assignment 4
USE store_front;

/*Consider a form where providing a Zip Code populates associated City and State. 
  Create appropriate tables and relationships for the same and write a SQL query for 
  that returns a Resultset containing Zip Code, City Names and States ordered by State Name and City Name.
*/

SELECT z.pincode, area_name, c.city_name, s.state_name
FROM zip_code z, city c, state s
WHERE z.city_name = c.city_name AND c.state_name = s.state_name
ORDER BY s.state_name, c.city_name; 


                    
    