package cage;

/**
 * It will define properties of Cage
 * 
 * @author Shubham Jain
 *
 */
public class Cage {
	private final String typeOfAnimal;
	private final String categoryOfAnimal;
	private final int maximumCapacity;
	private final int cageId;
	private final int zoneId;
	int sparseCapacity; 							// Available Capacity of cage

	public Cage(String typeOfAnimal, String categoryOfAnimal, int maximumCapacity, int cageId, int zoneId) {
		this.typeOfAnimal = typeOfAnimal;
		this.categoryOfAnimal = categoryOfAnimal;
		this.maximumCapacity = maximumCapacity;
		this.cageId = cageId;
		this.zoneId = zoneId;
		this.sparseCapacity = maximumCapacity;
	}

	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	public int getMaximumCapacity() {
		return maximumCapacity;
	}

	public int getCageId() {
		return cageId;
	}

	public int getZoneId() {
		return zoneId;
	}

	public int getSparseCapacity() {
		return sparseCapacity;
	}

	public void setSparseCapacity(int sparseCapacity) {
		this.sparseCapacity = sparseCapacity;
	}

}
