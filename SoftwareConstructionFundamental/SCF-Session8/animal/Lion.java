package animal;

/**
 * It will define properties of Lion
 * @author user36
 *
 */
public class Lion extends Mammal {
    final String type = "Lion";
    final String sound = "Roar";

    public Lion(String name, int id, int age, double weight) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.weight = weight;

    }

    String getInfo() {
        String info = "";

        info = name + "/" + age + "/" + id + "/" + category + "/" + type + "/"
                + weight + "/" + sound;
        return info;

    }
}
