/**
 * This class defines vertex type 
 * @author Shubham Jain
 */
public class edgeType {
	private int vertex;
	private int weight;
	
	public edgeType(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	
	/**
	 * Returns Vertex Number
	 * @return
	 */
	public int getVertex() {
	    return vertex;
	}
	
	/**
	 * Returns weight of edge
	 * @return
	 */
	public int getWeight() {
	    return weight;
	}
}