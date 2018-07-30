package animal;
import java.awt.image.CropImageFilter;

/**
 * It will define properties of Crocodile
 * @author Shubham Jain
 *
 */
public class Crocodile extends Reptile{
    final String type = "Crocodile";
    final String sound = "Hissing";

    public Crocodile(String name, int id, int age, double weight) {
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
