package br.sk;

import org.fusesource.jansi.AnsiConsole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.sk.internal.action.ActionLoader;

@SpringBootApplication
public class SkApplication implements CommandLineRunner {

	@Autowired
	private ActionLoader actionLoader;

	public static void main(String[] args) {
		AnsiConsole.systemInstall();
		SpringApplication.run(SkApplication.class, args);
		AnsiConsole.systemUninstall();
	}

	@Override
	public void run(String... arg0) throws Exception {
		actionLoader.loadAll();
	}
}
