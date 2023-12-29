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
		System.out.println("Программа запущена. help - список доступных команд");
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

	private void showCommands() {
		StringBuilder sb = new StringBuilder();
		sb.append("help - список команд\n");
		sb.append("info - вывод таблицы\n");
		sb.append("train - тренировка животного(добавление команды)\n");
		sb.append("del - удалить животное\n");
		sb.append("add - добавить животное\n");
		System.out.println(sb);
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
		System.out.println("Выберите ID животного для удаления: ");
		int id = scanner.nextInt();
		if (!presenter.deleteCreature(choiceType(), id)) {
			System.out.println("Животное удалено из реестра");
		} else {
			System.out.println("Животного с таким id нет в реестре");
		}

	}

	@Override
	public void trainCreature() {
		System.out.println("Выберите ID животного для обучения: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Напишите название команды");
		String nameCommand = scanner.nextLine();
		System.out.println("Напишите описание команды");
		String desc = scanner.nextLine();
		if (!presenter.trainCreature(choiceType(), id, nameCommand, desc)) {
			System.out.println("Тренировка прошла успешно");
		} else {
			System.out.println("Новая команда не добавилась");
		}

	}

	@Override
	public void getInfo() {
		System.out.println(presenter.getInfo(choiceType()));
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
