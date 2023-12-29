package model;

import java.util.HashMap;
import java.util.Map;

/* Класс для хранения зверей и взаимодействия с ними*/
public class StoreAnimals {
	private Map<TypesOfCreatures, Map<Integer, Animal>> animals;

	public StoreAnimals() {
		animals = new HashMap<>();
	}

	public boolean addCreature(TypesOfCreatures type, Animal animal) {
		if (animals.get(type) == null) {
			animals.put(type, new HashMap<Integer, Animal>());
		}
		animals.get(type).put(animal.getID(), animal);
		System.out.println(animals);
		return true;
	}

	public boolean deleteCreature(TypesOfCreatures type, Animal animal) {
		if (animals.get(type).containsValue(animal)) {
			animals.get(type).values().remove(animal);
			return true;
		}
		return false;
	}

	public Animal findCreature(TypesOfCreatures type, int ID) {
		return animals.get(type).get(ID);
	}

	public boolean trainCreature(TypesOfCreatures type, int ID, Command c) {
		return animals.get(type).get(ID).trainAnimal(c);
	}
	public String getInfo(TypesOfCreatures type) {
		if (animals.get(type) == null) return "Реестр пуст";
		return animals.get(type).toString();
	}
}
