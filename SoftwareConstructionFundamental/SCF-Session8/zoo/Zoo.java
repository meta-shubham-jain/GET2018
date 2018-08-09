package zoo;

import zone.*;
import cage.*;
import animal.*;
import java.util.List;
import java.time.zone.ZoneRulesException;
import java.util.ArrayList;

/**
 * It will have all properties and operations of Zoo
 * 
 * @author Shubham Jain
 *
 */
public class Zoo {
	public static List<Zone> zoneList = new ArrayList<Zone>();
	public static List<Cage> cageList = new ArrayList<Cage>();
	public static List<Animal> animalList = new ArrayList<Animal>();
	static int zoneId = 1;
	static int cageId = 1;
	static int animalId = 1;

	/**
	 * It will check whether animal with the given name is already exists or not
	 * 
	 * @param name
	 * @return boolean
	 */
	boolean isNameUnique(String name) {
		boolean isUnique = true;
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i).getName().equalsIgnoreCase(name)) {
				isUnique = false;
				break;
			}
		}
		return isUnique;
	}

	/**
	 * It will add Zone in Zoo
	 * 
	 * @param maximumNoOfCages
	 * @param categoryOfAnimal
	 * @param hasCanteen
	 * @param hasPark
	 * @return
	 */
	public boolean addZone(int maximumNoOfCages, String categoryOfAnimal, boolean hasCanteen, boolean hasPark) {
		boolean isZoneAdded = false;
		if (categoryOfAnimal == null && categoryOfAnimal.length() == 0) {
			throw new NullPointerException("Category Of Animal in Zone Can't be Null or Zero");
		}
		for (Zone.Category category : Zone.Category.values()) {
			if (category.name().equalsIgnoreCase(categoryOfAnimal)) {
				Zone newZone = new Zone(maximumNoOfCages, zoneId, categoryOfAnimal, hasCanteen, hasPark);
				zoneList.add(newZone);
				zoneId++;
				isZoneAdded = true;
				break;
			}
		}
		return isZoneAdded;
	}

	/**
	 * It will add Cage in Zone of Zoo
	 * 
	 * @param typeOfAnimal
	 * @param maximumCapacity
	 * @param zoneId
	 * @return
	 */
	public boolean addCage(String typeOfAnimal, int maximumCapacity, int zoneId) {
		boolean isCageAdded = false;
		boolean isZoneAvailable = false;
		String category = "";
		Zone zone = null;
		if (typeOfAnimal == null || typeOfAnimal.length() == 0) {
			throw new NullPointerException("Category Of Animal in Zone Can't be Null or Zero");
		}
		for (int i = 0; i < zoneList.size(); i++) {
			if (zoneList.get(i).getZoneId() == zoneId) {
				isZoneAvailable = true;
				category = zoneList.get(i).getCategoryOfAnimal();
				zone = zoneList.get(i);
				break;
			}
		}
		if (isZoneAvailable) {
			for (AnimalEnum animal : AnimalEnum.values()) {
				if (animal.getType().equalsIgnoreCase(typeOfAnimal) && animal.getCategory().equalsIgnoreCase(category)
						&& zone.getSparseCapacity() > 0) {
					Cage cage = new Cage(typeOfAnimal, category, maximumCapacity, cageId, zoneId);
					cageId++;
					isCageAdded = true;
					zone.setSparseCapacity(zone.getSparseCapacity() - 1);
					cageList.add(cage);
					break;
				}
			}
		}
		return isCageAdded;
	}

	/**
	 * It will add animal in Cage of Zone of Zoo
	 * 
	 * @param name
	 * @param age
	 * @param weight
	 * @param typeOfAnimal
	 * @return
	 */
	public boolean addAnimal(String name, int age, double weight, String typeOfAnimal) {
		boolean isAnimalAdded = false;
		String categoryOfAnimal = null;
		if (name == null || name.length() == 0 || typeOfAnimal == null || typeOfAnimal.length() == 0) {
			throw new NullPointerException("Name Of Animal or Type Can't be Null or Zero");
		}

		/*
		 * Checking if animal with the given name is already present or not
		 */
		if (isNameUnique(name)) {
			for (AnimalEnum animal : AnimalEnum.values()) {
				if (animal.getType().equalsIgnoreCase(typeOfAnimal)) {
					categoryOfAnimal = animal.getCategory();
					// System.out.println(categoryOfAnimal);
					break;
				}
			}
			if (categoryOfAnimal != null) {

				/*
				 * Checking if cage with given type is available or not If available and has
				 * space add the animal
				 */
				for (int i = 0; i < cageList.size(); i++) {
					if ((cageList.get(i).getTypeOfAnimal().equalsIgnoreCase(typeOfAnimal))
							&& (cageList.get(i).getSparseCapacity() > 0)) {
						typeOfAnimal = typeOfAnimal.toUpperCase();
						isAnimalAdded = true;
						switch (typeOfAnimal) {
						case "LION":
							animalList.add(new Lion(name, animalId, age, weight));
							cageList.get(i).setSparseCapacity(cageList.get(i).getSparseCapacity() - 1);
							cageList.get(i).getSparseCapacity();
							animalId++;
							break;
						case "CROCODILE":
							animalList.add(new Crocodile(name, animalId, age, weight));
							cageList.get(i).setSparseCapacity(cageList.get(i).getSparseCapacity() - 1);
							animalId++;
							break;
						case "PEACOCK":
							animalList.add(new Peacock(name, animalId, age, weight));
							cageList.get(i).setSparseCapacity(cageList.get(i).getSparseCapacity() - 1);
							animalId++;
							break;
						}
					}
				}
			}
		}
		return isAnimalAdded;
	}

	/**
	 * It will remove animal from zoo
	 * 
	 * @param name
	 * @return
	 */
	public boolean removeAnimal(String name) {
		boolean isAnimalRemoved = false;
		String typeOfAnimal;
		if (name == null || name.length() == 0) {
			throw new NullPointerException("Name of Animal Can't be Null or Zero");
		}
		/*
		 * Checking for animal in animal list
		 */
		for (int i = 0; i < animalList.size(); i++) {
			if (animalList.get(i).getName().equalsIgnoreCase(name)) {
				typeOfAnimal = animalList.get(i).getType();
				animalList.remove(i);
				isAnimalRemoved = true;

				/*
				 * Increasing the capacity of cage by 1
				 */
				for (int j = 0; j < cageList.size(); j++) {
					if (cageList.get(j).getTypeOfAnimal().equals(typeOfAnimal)
							&& (cageList.get(j).getSparseCapacity() < cageList.get(j).getMaximumCapacity())) {
						cageList.get(j).setSparseCapacity(cageList.get(j).getSparseCapacity() + 1);
						break;
					}
					break;
				}
			}
		}
		return isAnimalRemoved;
	}
}