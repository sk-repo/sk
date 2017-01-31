package br.sk.internal.action;

import java.io.Serializable;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.stereotype.Component;

@Component
public class ActionRunner implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ScriptEngine engine;

	public ActionRunner() {
		super();
		ScriptEngineManager manager = new ScriptEngineManager();
		this.engine = manager.getEngineByName("nashorn");
	}

	public void runPrepare(Action action) {
		
	}

	public void runExecute(Action action) {

	}
}
