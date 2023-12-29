package console;

import java.util.Arrays;
import java.util.Scanner;

import model.TypesOfCreatures;
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
		boolean flag = true;
		System.out.println("Программа запущена");
		do {
			switch (scanner.nextLine()) {
			case "train" -> trainCreature();
			case "info" -> getInfo();
			case "del" -> deleteCreature();
			case "add" -> addCreature();
			case "help" -> showCommands();
			case "q" -> flag = false;
			default -> System.out.println("Команда не распознана");
			}

		} while (flag);
	}

	private String showCommands() {
		StringBuilder sb = new StringBuilder();
		sb.append("help - список команд");
		sb.append("info - вывод таблицы");
		sb.append("train - тренировка животного(добавление команды)");
		sb.append("del - удалить животное");
		sb.append("add - добавить животное");
		return sb.toString();
	}

	@Override
	public void addCreature() {
		System.out.println("Напишите вид животного и его имя и возраст(пример: волки волк1 12)");
		String[] tmpArr = scanner.nextLine().split(" ");
		try {
			presenter.addCreature(choiceType(), tmpArr[0], tmpArr[1], Integer.parseInt(tmpArr[2]));
			System.out.println("Животное добавлено в реестр успешно");

		} catch (Exception e) {
			System.out.println(e);
		}
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

	}

	private TypesOfCreatures choiceType() {
		System.out.println("Выберите тип животного: ");
		System.out.println(Arrays.toString(TypesOfCreatures.values()));
		TypesOfCreatures type = TypesOfCreatures.PETS; // по умолчанию
		var choice = scanner.nextLine();
		if (choice.equals(TypesOfCreatures.PETS.toString())) {
			type = TypesOfCreatures.PETS;
			System.out.println("Домашние животные");
		} else if (choice.equals(TypesOfCreatures.PACK_ANIMALS.toString())) {
			type = TypesOfCreatures.PACK_ANIMALS;
			System.out.println("Вьючные животные");
		}
		return type;
	}

}
