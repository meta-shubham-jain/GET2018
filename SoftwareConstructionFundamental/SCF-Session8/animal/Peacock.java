package animal;

/**
 * It will define properties of Peacock
 * 
 * @author Shubham Jain
 *
 */
public class Peacock extends Bird {
	final String type = "Peacock";
	final String sound = "Scream";
	final int heightOfFlying = 25;

	public Peacock(String name, int id, int age, double weight) {
		this.name = name;
		this.age = age;
		this.id = id;
		this.weight = weight;
	}

	/**
	 * It will return type of animal
	 */
	public String getType() {
		return type;
	}

	/**
	 * It will return information about animal
	 */
	String getInfo() {
		String info = "";
		info = name + "/" + age + "/" + id + "/" + category + "/" + type + "/" + weight + "/" + sound + "/"
				+ heightOfFlying;
		return info;
	}
}
