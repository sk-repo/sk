package br.sk.service;

import java.io.Serializable;

import org.fusesource.jansi.Ansi;

public class ConsoleService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void log(String message, Object... args) {
		System.out.println(Ansi.ansi().render(String.format(message, args)));
	}

	public static void log(String message) {
		System.out.println(Ansi.ansi().render(message));
	}

}
