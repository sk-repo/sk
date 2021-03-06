package br.sk;

import static org.fusesource.jansi.Ansi.ansi;

import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SkApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	}

}
