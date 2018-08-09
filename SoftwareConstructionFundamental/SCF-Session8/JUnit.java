import static org.junit.jupiter.api.Assertions.*;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import zoo.Zoo;

class JUnit {
	Zoo zoo = new Zoo();

	@Before
	public void init() {
		zoo.addZone(2, "Mammal", true, false);
		zoo.addZone(2, "Reptile", false, false);
		zoo.addZone(3, "Bird", true, false);
		zoo.addCage("Lion", 5, 1);
		zoo.addCage("Crocodile", 2, 2);
		zoo.addCage("Peacock", 3, 3);
		zoo.addAnimal("Lion-1", 1, 20, "Lion");
		zoo.addAnimal("Lion-2", 2, 52, "Lion");
		zoo.addAnimal("Lion-3", 3, 102, "Lion");
		zoo.addAnimal("Crocodile-1", 4, 52, "Crocodile");
		zoo.addAnimal("Crocodile-2", 5, 102, "Crocodile");
		zoo.addAnimal("Peacock-1", 6, 52, "Peacock");
		zoo.addAnimal("Peacock-2", 7, 102, "Peacock");
	}

	@Test
	public void addZoneTest() {
		// Adding a new Zone for Mammals which has Canteen and Park both
		assertTrue(zoo.addZone(2, "Mammal", true, true));
	}

	@Test
	public void addCageTest() {
		// Adding a new cage in Mammal Zone
		assertFalse(zoo.addCage("Lion", 2, 1));
	}

	@Before
	public void addAnimalTest1() {
		// Adding a new animal of type Mammal
		assertTrue(zoo.addAnimal("Lion-4", 20, 100, "Lion"));
		assertTrue(zoo.addAnimal("Lion-5", 20, 100, "Lion"));
		assertTrue(zoo.addAnimal("Lion-6", 20, 100, "Lion"));
	}

	@Test
	public void addAnimalTest2() {
		// Adding a new animal with name already present in zoo
		assertFalse(zoo.addAnimal("Lion-2", 20, 100, "Lion"));
	}

	@Before
	public void removeAnimalTest() {
		// Removing a animal from zoo
		assertTrue(zoo.removeAnimal("Lion-2"));
	}

	@Test
	public void addZoneFullTest() {
		// Adding a cage when sparse capacity of zone is full
		assertFalse(zoo.addCage("Crocodile", 2, 3));
	}

	@Test
	public void addCageFullTest() {
		// Adding a animal when cage is already full
		assertFalse(zoo.addAnimal("Crocodile-5 ", 13, 70, "Crocodile"));
	}
}