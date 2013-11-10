package rule;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import managers.SemanticsManager;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import components.Component;
import components.InputXMLDocument;

public class Rule {
	private Element inputSemantic;
	private Element outputSementic;
	private ArrayList<Component> input;
	private ArrayList<Component> output;
	private String name;
	
	public Rule(){
		
	}
	
	public Rule(File file){
		SAXBuilder builder = new SAXBuilder();
		
		String ruleName = "";
	
		try{
			Document document = (Document) builder.build(file);
			Element verseNode = document.getRootElement();
			
			//get rule name
			ruleName = verseNode.getAttributeValue("name");
			setName(ruleName);
			
			Element item = verseNode.getChild("input");
			input = ProcessFile(item);
			
			item = verseNode.getChild("output");
			output = ProcessFile(item);
			
		}catch(Exception e){e.printStackTrace();}
	}
	
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
	
	private ArrayList<Component> ProcessFile(Element verseNode){			
	
			List<Element> clauseNodes = (List<Element>) verseNode.getChildren(SemanticsManager.COMPONENT);
			ArrayList<Component> clauseComponents = new ArrayList<Component>();
			for(Element clauseNode: clauseNodes)
				clauseComponents.add(Component.createInstance(clauseNode));
			
			return clauseComponents;
			
	}
	
	private boolean writeToXML(String filePath, Element rootElement){
		XMLOutputter xmlOutput = new XMLOutputter();
		xmlOutput.setFormat(Format.getPrettyFormat());
		try{
			xmlOutput.output(rootElement, new FileWriter(filePath));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
}
