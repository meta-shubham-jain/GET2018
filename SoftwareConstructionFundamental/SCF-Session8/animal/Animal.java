package animal;

/**
 * It will define properties of Animal
 * 
 * @author Shubham Jain
 *
 */
abstract public class Animal {

	protected String name;
	protected int id;
	protected int age;
	protected double weight;
	protected String category;
	protected String type;
	protected String sound;

	/**
	 * It will set age of animal
	 * 
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * It will set weight of animal
	 * 
	 * @param weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * It will return age of animal
	 * 
	 * @return
	 */
	public int getAge() {
		return age;
	}

	/**
	 * It will return weight of animal
	 * 
	 * @return
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * It will return name of animal
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * It will return id of animal
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * It will return category of animal
	 * 
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * It will return type of animal
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * It will return sound of animal
	 * 
	 * @return
	 */
	public String getSound() {
		return sound;
	}

	/**
	 * It will return information about animal
	 * 
	 * @return
	 */
	abstract String getInfo();
}