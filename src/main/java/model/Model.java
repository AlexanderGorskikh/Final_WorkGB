package model;

public class Model {
	StoreAnimals store;

	public Model() {
		store = new StoreAnimals();
	}

	public boolean addCreature(TypesOfCreatures type, String classAnimal, String name, int age) {
		return store.addCreature(type, new Animal(classAnimal, name, age));
	}

	public boolean deleteCreature(TypesOfCreatures type, int ID) {
		return store.deleteCreature(type, store.findCreature(type, ID));
	}

	public Animal findCreature(TypesOfCreatures type, int ID) {
		return store.findCreature(type, ID);
	}

	public boolean trainCreature(TypesOfCreatures type, int ID, Command c) {
		return store.trainCreature(type, ID, c);
	}

	public String getInfo(TypesOfCreatures type) {
		return store.getInfo(type);
	}
}
