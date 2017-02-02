package br.sk;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.Ansi.Color;
import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		SpringApplication.run(SkApplication.class, args);
		AnsiConsole.systemUninstall();
	}

	@Override
	public void run(String... arg0) throws Exception {
		Ansi.ansi().fg(Color.CYAN).a("Funcinou!");
	}
}
