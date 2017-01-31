package br.sk.internal.config;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("sk")
public class SkConfig {

	@NotNull
	private String workspace;

	@Value("#{environment['HOME']}/git/sk-actions")
	private String actionsPath;

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public String getActionsPath() {
		return actionsPath;
	}

	public void setActionsPath(String actionsPath) {
		this.actionsPath = actionsPath;
	}
}
