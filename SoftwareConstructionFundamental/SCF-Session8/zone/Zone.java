package zone;

/**
 * It will define properties of Zone
 * 
 * @author Shubham Jain
 *
 */
public class Zone {
	final int maximumNoOfcages;
	final String categoryOfAnimal;
	final int zoneId;
	boolean hasCanteen;
	boolean hasPark;
	int sparseCapacity; // Available Capacity of Zone

	/**
	 * This enum is for category of Animals
	 */
	public enum Category {
		Mammal, Reptile, Bird;
	}

	public Zone(int maximumNoOfCages, int zoneId, String categoryOfAnimal, boolean hasCanteen, boolean hasPark) {
		this.maximumNoOfcages = maximumNoOfCages;
		this.categoryOfAnimal = categoryOfAnimal;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
		this.zoneId = zoneId;
		this.sparseCapacity = maximumNoOfCages;
	}

	/**
	 * It will return maximum number of cages that a zone can have
	 * 
	 * @return
	 */
	public int getMaximumNoOfCages() {
		return maximumNoOfcages;
	}

	/**
	 * It will return category of animal of zone
	 * 
	 * @return
	 */
	public String getCategoryOfAnimal() {
		return categoryOfAnimal;
	}

	/**
	 * It will return sparse capacity of zone
	 * 
	 * @return
	 */
	public int getSparseCapacity() {
		return sparseCapacity;
	}

	/**
	 * It will return zone Id
	 * 
	 * @return
	 */
	public int getZoneId() {
		return zoneId;
	}

	/**
	 * It will return true if zone has park otherwise false
	 * 
	 * @return
	 */
	public boolean hasPark() {
		return hasPark;
	}

	/**
	 * It will return true if zone has canteen otherwise false
	 * 
	 * @return
	 */
	public boolean hasCanteen() {
		return hasPark;
	}

	/**
	 * It will set sparse capacity of zone
	 * 
	 * @param sparseCapacity
	 */
	public void setSparseCapacity(int sparseCapacity) {
		this.sparseCapacity = sparseCapacity;
	}
}