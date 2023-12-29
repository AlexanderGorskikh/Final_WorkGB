package presenter;

import console.UserInterface;
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

}
