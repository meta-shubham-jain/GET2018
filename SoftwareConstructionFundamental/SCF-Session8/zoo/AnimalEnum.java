package zoo;

public enum AnimalEnum {

    OneAnimal("Lion","Mammal"), TwoAnimal("Tiger","Mammal"), ThreeAnimal("Pigeon","Bird"), FourAnimal("Ostrich","Bird"), 
    FiveAnimal("Snake","Reptile"), SixAnimal("Crocodile","Reptile");
    
    String category;
    String type;
    
    AnimalEnum(String type, String category) {
        this.type=type;
        this.category=category;
    }
    
    public String getCategory() {
        return category;
    }
    public String getType() {
        return type;
    }
}
