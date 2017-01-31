package br.sk.internal.action;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.codeshelf.consoleui.prompt.ConsolePrompt;
import de.codeshelf.consoleui.prompt.PromtResultItemIF;
import de.codeshelf.consoleui.prompt.builder.PromptBuilder;

@Component
public class ActionDispatcher {

	@Autowired
	private ActionLoader actionLoader;

	@Autowired
	private ActionRunner actionRunner;

	public void dispatch() throws IOException {
		ConsolePrompt prompt = new ConsolePrompt();
		PromptBuilder promptBuilder = prompt.getPromptBuilder();
		//// @formatter:off
        promptBuilder.createInputPrompt()
	         .name("action")
	         .message("Digite o nome da ação")
	         .addPrompt();
        // @formatter:on
		HashMap<String, ? extends PromtResultItemIF> result = prompt.prompt(promptBuilder.build());
		PromtResultItemIF actionNameResult = result.get("action");
	}

}
