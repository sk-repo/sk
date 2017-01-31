package br.sk.internal.action;

import java.io.FileReader;
import java.nio.file.Path;

public class Action implements Comparable<Action> {

	private String name;

	private Path path;

	private FileReader actionFileReader;

	public Action(Path path) {
		super();
		this.path = path;
	}

	public String getName() {
		if (this.name == null) {
			this.name = path.toFile().getName();
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileReader getActionFileReader() {
		return actionFileReader;
	}

	public void setActionFileReader(FileReader actionFileReader) {
		this.actionFileReader = actionFileReader;
	}

	@Override
	public int compareTo(Action o) {
		return this.getName().compareTo(o.getName());
	}

}
