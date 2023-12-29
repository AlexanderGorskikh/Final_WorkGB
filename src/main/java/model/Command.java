package model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Command {
	private String name;
	private String desc;

	public Command(String name, String desc) {
		this.desc = desc;
		this.name = name;
	}
}
