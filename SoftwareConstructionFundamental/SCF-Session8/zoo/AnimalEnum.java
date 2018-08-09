package zoo;

public enum AnimalEnum {

	OneAnimal("Lion", "Mammal"), TwoAnimal("Tiger", "Mammal"), ThreeAnimal("Peacock", "Bird"),
	FourAnimal("Ostrich", "Bird"), FiveAnimal("Snake", "Reptile"), SixAnimal("Crocodile", "Reptile");

	String category;
	String type;

	AnimalEnum(String type, String category) {
		this.type = type;
		this.category = category;
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
}