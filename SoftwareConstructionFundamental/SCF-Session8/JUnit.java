import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import zoo.Zoo;

class JUnit {
	
	@Test
    public void addZoneTest() {
        // Adding a new Zone for Mammals which has Canteen and Park both
        assertTrue(new Zoo().addZone(2, "Mammal", true, true));
    }
    
    @Test
    public void addCageTest() {
        // Adding a new cage in Mammal Zone
        assertTrue(new Zoo().addCage("Lion", 2, 1)); 
    }
    
    @Before
    public void addAnimalTest1() {
        // Adding a new animal of type Mammal
        assertTrue(new Zoo().addAnimal("Lion-4", 20, 100,"Lion"));
    }
    
    @Test
    public void addAnimalTest2() {
        // Adding a new animal with name already present in zoo
        assertFalse(new Zoo().addAnimal("Lion-2", 20, 100,"Lion"));
    }
    
    @Before
    public void removeAnimalTest() {
        // Removing a animal from zoo
        assertTrue(new Zoo().removeAnimal("Lion-2"));
    }
    
    @Test
    public void addZoneFullTest() {
        // Adding a cage when sparse capacity of zone is full
        assertFalse(new Zoo().addCage("Crocodile", 2, 3)); 
    }
    
    @Test
    public void addCageFullTest() {
        // Adding a animal when cage is already full
        assertFalse(new Zoo().addAnimal("Crocodile-5 ", 13, 70, "Crocodile"));     
    } 
    
}
