import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Test;
import java.sql.Date;
import java.sql.SQLException;
import java.util.*;
import org.junit.Test;

public class QueryImplementationTest {
    QueryImplementation query = new QueryImplementation();
    
    @Test
    public void testQuery1() throws Exception {
        List<OrderDetails> expectedList = new ArrayList<OrderDetails>();        
        expectedList.add(new OrderDetails(9,Date.valueOf("2018-06-11"),3000));
        expectedList.add(new OrderDetails(2,Date.valueOf("2018-08-11"),3000));
        List<OrderDetails> actualList = query.query1(2);
        
        for(int i=0;i<actualList.size();i++) {
            assertEquals(expectedList.get(i).getOrderId(), actualList.get(i).getOrderId());
            assertEquals(expectedList.get(i).getDate(), actualList.get(i).getDate());
            assertEquals(expectedList.get(i).getOrderTotal(),actualList.get(i).getOrderTotal(),0.00);
        }   
    }
    
    @Test
    public void testQuery2() throws SQLException {
        List<Image> imageList = new ArrayList<Image>();        
        imageList.add(new Image(1,"image1.jpg"));
        imageList.add(new Image(1,"image2.jpg"));
        imageList.add(new Image(1,"image3.jpg"));
        imageList.add(new Image(1,"image4.jpg"));
        imageList.add(new Image(1,"image5.jpg"));
        imageList.add(new Image(2,"image.jpg"));
        imageList.add(new Image(3,"image.jpg"));
        imageList.add(new Image(1,"image.jpg"));
        assertEquals(8,query.query2(imageList));
    }
    
    @Test
    public void testQuery3() {
        assertEquals(17,query.query3()); 
    }
    
    @Test
    public void testQuery4() {
        List<ParentCategory> parentList = new ArrayList<ParentCategory>();
        parentList.add(new ParentCategory("Clothing",3));
        parentList.add(new ParentCategory("Electronic_Gadgets",4));
        parentList.add(new ParentCategory("Footwear",2));
        List<ParentCategory> actualList = query.query4();
        for (int i=0;i<parentList.size();i++) {
            assertEquals(parentList.get(i).getCategoryTitle(), actualList.get(i).getCategoryTitle());
            assertEquals(parentList.get(i).getCountOfChild(), actualList.get(i).getCountOfChild());
        }
    }
    
    @Test
    public void userIdtestWithLessThanOneTest() {
        try {
        query.query1(0);
        } catch(Exception ex) {
            assertEquals("User Id Should be greater than zero", ex.getMessage());
        }
}
    @Test
    public void userIdNotExistsTest() {
        try {
            query.query1(50);
        } catch(Exception ex) {
            assertEquals("User Id doesnot exists", ex.getMessage());
        }
    }
    
    @After
    public void testclose() {
        query.close();
    }
}