package animal;

/**
 * It will define properties of Peacock
 * 
 * @author user36
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

	public String getType() {
		return type;
	}

	String getInfo() {
		String info = "";

		info = name + "/" + age + "/" + id + "/" + category + "/" + type + "/" + weight + "/" + sound + "/"
				+ heightOfFlying;
		return info;
	}

}
