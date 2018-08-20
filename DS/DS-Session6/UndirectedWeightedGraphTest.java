import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class UndirectedWeightedGraphTest {
    UndirectedWeightedGraphUsingEdgeList graph;
    
    @Before
    public void initialize() throws Exception {
        graph = new UndirectedWeightedGraphUsingEdgeList(5);
        /*   2    3       
           0---1----2
           |  / \   |
          6| /8  \6 |7
           |/     \ |
           3--------4     
               9
        */  
        graph.addEdge(2, 0, 1);
        graph.addEdge(6, 0, 3);
        graph.addEdge(3, 1, 2);
        graph.addEdge(8, 1, 3);
        graph.addEdge(6, 1, 4);
        graph.addEdge(7, 2, 4);
        graph.addEdge(9, 3, 4);
    }
    
    @Test
    public void testaddingVertexNotInRange(){
        try{
            graph.addEdge(0, -1, 5);
        } catch(Exception ex) {
            assertEquals("Number of Vertices out of range",ex.getMessage());
        }
    }
    
    @Test
    public void testIsConnected() {
        assertTrue(graph.isConnected());
    }
    
    @Test
    public void testIsReachable() throws Exception {
        List<Integer> expected =  new ArrayList<Integer>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        assertEquals(expected, graph.isReachable(0));
    }
    
    @Test
    public void testMst() {
        List<Integer> expected =  new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(3);
        assertEquals(expected, graph.mst());
    }
    
    @Test
    public void testMst2() throws Exception {
    /*    5 
        0---1
        |  /| \6 
       7|1/ |9 2
        |/  | /4
        4---3
          2     */
        graph = new UndirectedWeightedGraphUsingEdgeList(5);
        graph.addEdge(5, 0, 1);
        graph.addEdge(7, 0, 4);
        graph.addEdge(6, 1, 2);
        graph.addEdge(9, 1, 3);
        graph.addEdge(1, 1, 4);
        graph.addEdge(4, 2, 3);
        graph.addEdge(2, 3, 4);  
        List<Integer> expected =  new ArrayList<Integer>();
        expected.add(0);
        expected.add(1);
        expected.add(4);
        expected.add(3);
        expected.add(2);
        assertEquals(expected, graph.mst());
    }
    
    @Test
    public void testShortestPath() throws Exception {
        assertEquals(8, graph.shortestPath(0,4));
    }
    
    @Test
    public void testShortestPath2() throws Exception {
    /*    5 
        0---1
        |  /| \6 
       7|1/ |9 2
        |/  | /4
        4---3
          2     */
        graph = new UndirectedWeightedGraphUsingEdgeList(5);
        graph.addEdge(5, 0, 1);
        graph.addEdge(7, 0, 4);
        graph.addEdge(6, 1, 2);
        graph.addEdge(9, 1, 3);
        graph.addEdge(1, 1, 4);
        graph.addEdge(4, 2, 3);
        graph.addEdge(2, 3, 4); 
        assertEquals(8, graph.shortestPath(0,3));
    }
}