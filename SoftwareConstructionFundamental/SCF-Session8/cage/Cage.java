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
	int sparseCapacity; // Available Capacity of cage

	public Cage(String typeOfAnimal, String categoryOfAnimal, int maximumCapacity, int cageId, int zoneId) {
		this.typeOfAnimal = typeOfAnimal;
		this.categoryOfAnimal = categoryOfAnimal;
		this.maximumCapacity = maximumCapacity;
		this.cageId = cageId;
		this.zoneId = zoneId;
		this.sparseCapacity = maximumCapacity;
	}

	/**
	 * It will return type of Animal
	 * 
	 * @return
	 */
	public String getTypeOfAnimal() {
		return typeOfAnimal;
	}

	/**
	 * It will return category of animal of cage
	 * 
	 * @return
	 */
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	/**
	 * It will return maximum capacity of cage
	 * 
	 * @return
	 */
	public int getMaximumCapacity() {
		return maximumCapacity;
	}

	/**
	 * It will return Cage Id
	 * 
	 * @return
	 */
	public int getCageId() {
		return cageId;
	}

	/**
	 * It will return Zone Id
	 * 
	 * @return
	 */
	public int getZoneId() {
		return zoneId;
	}

	/**
	 * It will return sparse capacity of cage
	 * 
	 * @return
	 */
	public int getSparseCapacity() {
		return sparseCapacity;
	}

	/**
	 * It will set sparse capacity of cage
	 * 
	 * @param sparseCapacity
	 */
	public void setSparseCapacity(int sparseCapacity) {
		this.sparseCapacity = sparseCapacity;
	}
}
