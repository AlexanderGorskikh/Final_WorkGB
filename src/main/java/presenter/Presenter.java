package presenter;

import console.UserInterface;
import model.Command;
import model.Model;
import model.TypesOfCreatures;

public class Presenter {
	UserInterface ui;
	Model model;

	public Presenter(UserInterface ui) {
		this.ui = ui;
		model = new Model();
	}
	public boolean addCreature(TypesOfCreatures type, String classAnimal, String name, int age) {
		return model.addCreature(type, classAnimal, name, age);
	}
	public boolean deleteCreature(TypesOfCreatures type, int ID) {
		return model.deleteCreature(type, ID);
	}
	public boolean trainCreature(TypesOfCreatures type, int ID, String nameCommand, String descCommand) {
		return model.trainCreature(type, ID, new Command(nameCommand, descCommand));
	}
	public String getInfo(TypesOfCreatures type) {
		return model.getInfo(type);
	}
}
