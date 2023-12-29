package console;

import java.util.Scanner;

import presenter.Presenter;

public class Console implements UserInterface {
	Scanner scanner;
	Presenter presenter;

	public Console() {
		scanner = new Scanner(System.in);
		presenter = new Presenter(this);
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addCreature() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCreature() {
		// TODO Auto-generated method stub

	}

	@Override
	public void trainCreature() {
		// TODO Auto-generated method stub

	}

	@Override
	public void getInfo() {
		// TODO Auto-generated method stub

	}

}
