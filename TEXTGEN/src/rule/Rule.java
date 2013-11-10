package rule;

import java.util.ArrayList;
import org.jdom2.Element;
import components.Component;

public class Rule {
	private Element inputSemantic;
	private Element outputSementic;
	private ArrayList<Component> input;
	private ArrayList<Component> output;
	private String name;
	
	public ArrayList<Component> getInput() {
		return input;
	}
	public void setInput(ArrayList<Component> input) {
		this.input = input;
	}
	public ArrayList<Component> getOutput() {
		return output;
	}
	public void setOutput(ArrayList<Component> output) {
		this.output = output;
	}
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	
	
}
