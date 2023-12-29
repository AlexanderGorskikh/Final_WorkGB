package model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

public class Animal implements Comparable<Animal> {
	static int animalsCount;
	@Getter
	private int ID;
	@Getter
	@Setter
	private String type, name;
	@Getter
	@Setter
	private int age;
	@Getter
	private Set<Command> commands;

	public Animal(String type, String name, int age) {
		ID = animalsCount;
		animalsCount++;
		this.type = type;
		this.name = name;
		this.age = age;
	}

	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		sb.append(ID).append(": ");
		sb.append(type).append(" | ");
		sb.append(name).append(" | ");
		sb.append(age).append(" | ");
		sb.append(commands);
		return sb.toString();
	}

	public boolean trainAnimal(Command c) {
		return commands.add(c);
	}

	@Override
	public int compareTo(Animal o) {
		return this.ID - o.getID();
	}

	@Override
	public String toString() {
		return getInfo();
	}
}
