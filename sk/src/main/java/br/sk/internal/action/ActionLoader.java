package br.sk.internal.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.sk.internal.config.SkConfig;
import br.sk.service.ConsoleService;

/**
 * Classe responsável pelo carregamento das actions.
 * 
 * @author jcruz
 *
 */
@Component
public class ActionLoader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private SkConfig skConfig;

	private SortedSet<Action> actions;

	/**
	 * Carrega todos as actions de {@link SkConfig#getActionRepo()}
	 * 
	 * @throws IOException
	 */
	public void loadFromRepo() throws IOException {
		if (isValidActionsPath()) {
			//// @formatter:off
			this.actions = Files.list(Paths.get(skConfig.getActionRepo()))
					.filter(Files::isDirectory)
					.filter(this::hasActionJSFile)
					.map(path -> new Action(path, loadActionJSFile(path)))
					.collect(Collectors.toCollection(TreeSet::new));
			// @formatter:on
			ConsoleService.log("@|cyan %d actions carregadas. |@", new Object[] { this.actions.size() });
			return;
		}
		ConsoleService.log("@|red Diretório de actions não existe. |@");
	}

	private boolean isValidActionsPath() {
		return Files.exists(Paths.get(skConfig.getActionRepo()));
	}

	private boolean hasActionJSFile(Path path) {
		try {
			return Files.list(path).anyMatch(p -> p.toString().endsWith("action.js"));
		} catch (IOException e) {
			ConsoleService.log("@|red %s. |@", e.getMessage());
		}
		return false;
	}

	private FileReader loadActionJSFile(Path path) {
		try {
			return new FileReader(new File(path.toFile().getAbsolutePath().concat("/").concat("action.js")));
		} catch (FileNotFoundException e) {
			ConsoleService.log("@|red %s. |@", e.getMessage());
		}
		return null;
	}

	public SortedSet<Action> getActions() {
		return actions;
	}

}
