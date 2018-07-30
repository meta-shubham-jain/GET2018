package animal;

/**
 * It will define properties of Animal
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
     
    public void setAge(int age){
        this.age = age;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    public int getAge() {
        return age;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String getName() {
        return name;
    }
    
    public int getId() {
        return id;
    }
    
    public String getCategory(){
        return category;
    }
    
    public String getType() {
        return type;
    }
    
    public String getSound() {
        return sound;
    } 
    
    abstract String getInfo();
    
}