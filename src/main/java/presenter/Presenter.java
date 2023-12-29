package presenter;

import console.UserInterface;
import model.Model;

public class Presenter {
	UserInterface ui;
	Model model;

	public Presenter(UserInterface ui) {
		this.ui = ui;
		model = new Model();
	}

}
