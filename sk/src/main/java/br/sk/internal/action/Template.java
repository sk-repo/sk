package br.sk.internal.action;

import java.io.FileReader;
import java.io.Serializable;

public class Template implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private FileReader templateFileReader;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FileReader getTemplateFileReader() {
		return templateFileReader;
	}

	public void setTemplateFileReader(FileReader templateFileReader) {
		this.templateFileReader = templateFileReader;
	}

}
