package animal;

/**
 * It will define properties of Lion
 * 
 * @author Shubham Jain
 *
 */
public class Lion extends Mammal {
	final String type = "Lion";
	final String sound = "Roar";
	final int speed = 80;

	public Lion(String name, int id, int age, double weight) {
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

		info = name + "/" + age + "/" + id + "/" + category + "/" + type + "/" + weight + "/" + sound + "/" + speed;
		return info;
	}
}
