import java.util.List;

/**
 * Interface Defining Functions for Undirected Weighted Graph
 * 
 * @author Shubham Jain
 */
public interface UndirectedWeightedGraph {
    /**
     * Checking if a graph is connected or not
     * 
     * @return true if connected otherwise false
     */
    public boolean isConnected();

    /**
     * Returns List of Traversed Vertex
     * 
     * @param vertex
     * @return
     * @throws Exception
     */
    public List<Integer> isReachable(int vertex) throws Exception;

    /**
     * Returns List of Traversed Vertex in minimum spanning tree
     * 
     * @return
     */
    public List<Integer> mst();

    /**
     * Returns shortest path between two vertices
     * 
     * @param vertex1
     * @param vertex2
     * @return
     * @throws Exception
     */
    public int shortestPath(int vertex1, int vertex2) throws Exception;
}