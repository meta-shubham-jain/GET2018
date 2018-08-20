import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * The class implements the methods defined in Interface undirected graph
 * @author Shubham Jain
 */
public class UndirectedWeightedGraphUsingEdgeList implements UndirectedWeightedGraph {

    /* Linkedlist stores the graph */
    private LinkedList<edgeType> edgeList[];

    /* Stores number of noOfVertices */
    private int noOfVertices;

    /**
     * Initializes the graph
     * 
     * @param v
     */
    public UndirectedWeightedGraphUsingEdgeList(int noOfVertices) {
        edgeList = new LinkedList[noOfVertices];
        this.noOfVertices = noOfVertices;
        for (int i = 0; i < noOfVertices; i++) {
            edgeList[i] = new LinkedList<edgeType>();
        }
    }

    /**
     * Adds an edge to graph
     * 
     * @param weight
     * @param source
     * @param destination
     * @throws Exception
     */
    public void addEdge(int weight, int source, int destination)
            throws Exception {
        if (source >= noOfVertices || destination >= noOfVertices || source < 0
                || destination < 0 || weight < 0) {
            throw new Exception("Number of Vertices out of range");
        }
        edgeList[source].add(new edgeType(destination, weight));
        edgeList[destination].add(new edgeType(source, weight));
    }

    /**
     * Checks if graph is connected
     */
    public boolean isConnected() {
        boolean[] visited = new boolean[noOfVertices];
        visited = dfstraverse(0, visited);
        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the list of nodes which are reachable from graph
     */
    public List<Integer> isReachable(int vertex) throws Exception {
        if (vertex >= noOfVertices || vertex < 0) {
            throw new Exception("noOfVertices out of range");
        }
        boolean[] visited = new boolean[noOfVertices];
        visited = dfstraverse(vertex, visited);
        List<Integer> reachableList = new ArrayList<Integer>();
        for (int i = 0; i < noOfVertices; i++) {
            if (visited[i] && i != vertex) {
                reachableList.add(i);
            }
        }
        return reachableList;
    }

    /**
     * Traverses graph in depth first search style
     * 
     * @param v
     * @param visited
     * @return
     */
    private boolean[] dfstraverse(int v, boolean[] visited) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(v);
        do {
            int top = stack.pop();
            if (!visited[top]) {
                visited[top] = true;
                for (int itr = 0; itr < edgeList[top].size(); itr++) {
                    stack.push(edgeList[top].get(itr).getVertex());
                }
            }
        } while (!stack.isEmpty());
        return visited;
    }

    /**
     * Finds the minimum spanning tree Return the list of vertices in order in
     * which they form the MST
     */
    public List<Integer> mst() {
        List<Integer> list = new ArrayList<Integer>();
        int[] parent = new int[noOfVertices];
        int[] keys = new int[noOfVertices];
        boolean[] visited = new boolean[noOfVertices];
        for (int itr = 0; itr < noOfVertices; itr++) {
            keys[itr] = Integer.MAX_VALUE;
            visited[itr] = false;
        }
        keys[0] = 0;
        parent[0] = -1;
        for (int itr = 0; itr < noOfVertices; itr++) {
            int nextVertex = minKey(keys, visited);
            list.add(nextVertex);
            visited[nextVertex] = true;
            for (int i = 0; i < edgeList[nextVertex].size(); i++) {
                if (visited[edgeList[nextVertex].get(i).getVertex()] == false
                        && edgeList[nextVertex].get(i).getWeight() < keys[edgeList[nextVertex]
                                .get(i).getVertex()]) {
                    keys[edgeList[nextVertex].get(i).getVertex()] = edgeList[nextVertex]
                            .get(i).getWeight();
                    parent[edgeList[nextVertex].get(i).getVertex()] = nextVertex;
                }
            }
        }
        return list;
    }

    /**
     * Finds the vertex having minimum weight
     * 
     * @param keys
     * @param visited
     * @return minIndex
     */
    private int minKey(int[] keys, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < noOfVertices; i++) {
            if (visited[i] == false && keys[i] <= min) {
                min = keys[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    /**
     * Finds the shortest path from node a to node b returns the weight from
     * node a to node b
     */
    public int shortestPath(int vertex1, int vertex2) throws Exception {
        if (vertex1 >= noOfVertices || vertex2 >= noOfVertices || vertex1 < 0
                || vertex2 < 0) {
            throw new Exception("noOfVertices not in range");
        }
        int[] keys = new int[noOfVertices];
        boolean[] visited = new boolean[noOfVertices];
        for (int itr = 0; itr < noOfVertices; itr++) {
            keys[itr] = Integer.MAX_VALUE;
            visited[itr] = false;
        }
        keys[vertex1] = 0;
        for (int itr = 0; itr < noOfVertices; itr++) {
            int nextVertex = minKey(keys, visited);
            visited[nextVertex] = true;
            for (int i = 0; i < edgeList[nextVertex].size(); i++) {
                if (visited[edgeList[nextVertex].get(i).getVertex()] == false
                        && edgeList[nextVertex].get(i).getWeight()
                                + keys[nextVertex] < keys[edgeList[nextVertex]
                                .get(i).getVertex()]) {
                    keys[edgeList[nextVertex].get(i).getVertex()] = edgeList[nextVertex]
                            .get(i).getWeight() + keys[nextVertex];
                }
            }
        }
        return keys[vertex2];
    }
}