package rule;

import components.Component;

public class Rule {
	private Component input;
	private Component output;
	private String name;
	
	public Component getInput() {
		return input;
	}
	public void setInput(Component input) {
		this.input = input;
	}
	public Component getOutput() {
		return output;
	}
	public void setOutput(Component output) {
		this.output = output;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	
}
