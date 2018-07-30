package zone;

/**
 * It will define properties of Zone
 * @author Shubham Jain
 *
 */
public class Zone {
    final int maximumNoOfcages;
    final String categoryOfAnimal;
    final int zoneId;
    boolean hasCanteen;
    boolean hasPark;
    int sparseCapacity;
    
    /**
     * This enum is for category of Animals
     */
    public enum Category {
        Mammal,Reptile,Peacock;
    }
    
    public Zone(int maximumNoOfCages, int zoneId, String categoryOfAnimal, boolean hasCanteen,
            boolean hasPark) {
        this.maximumNoOfcages = maximumNoOfCages;
        this.categoryOfAnimal = categoryOfAnimal;
        this.hasPark = hasPark;
        this.hasCanteen = hasCanteen;
        this.zoneId = zoneId;
        this.sparseCapacity = maximumNoOfCages;
    }
    
    public int getMaximumNoOfCages() {
        return maximumNoOfcages;
    }
    
    public String getCategoryOfAnimal() {
        return categoryOfAnimal;
    }

    public int getSparseCapacity() {
        return sparseCapacity;
    }
    
    public int getZoneId() {
        return zoneId;
    }
    
    public boolean hasPark() {
        return hasPark;
    }
    
    public boolean hasCanteen() {
        return hasPark;
    }
    
    public void setSparseCapacity(int sparseCapacity) {
        this.sparseCapacity = sparseCapacity;
    }

}
