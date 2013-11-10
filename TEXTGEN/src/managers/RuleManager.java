package managers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import rule.Rule;
import rule.RuleType;

import components.Component;
import components.Leaf;
import components.Phrase;

public class RuleManager {
	
	public static void main(String[] args ){
		SAXBuilder builder = new SAXBuilder();
		File file = new File("C:/Users/user/Downloads/Test/Rule_Format.xml");
		DefaultMutableTreeNode dmt = new DefaultMutableTreeNode();
		String ruleName = "";
	
		try{
			Document document = (Document) builder.build(file);
			Element verseNode = document.getRootElement();
			dmt = getRules(file);
			
			Rule r = (Rule)dmt.getUserObject();
			System.out.println();
			System.out.println();
			System.out.println(r.getName());
			//System.out.println(r.getInput().get(0).getName());
			for(Component c : r.getInput()){
				if(c.isLeaf()){
					Leaf l = (Leaf)c;
					System.out.println(l.getName());
					System.out.println(l.getConcept());
					System.out.println(l.getLexicalSense());
				}
				else{
					Phrase p = (Phrase) c;
					System.out.println(p.getName());
					System.out.println(p.getDescription());
				}
				System.out.println();
			}
			for(Component c : r.getOutput()){
				if(c.isLeaf()){
					Leaf l = (Leaf)c;
					System.out.println(l.getName());
					System.out.println(l.getConcept());
					System.out.println(l.getLexicalSense());
				}
				else{
					Phrase p = (Phrase) c;
					System.out.println(p.getName());
					System.out.println(p.getDescription());
				}
				System.out.println();
			}
			
			r.writeToXML("C:/Users/user/Downloads/Test/TestSave.xml", verseNode);
		}catch(Exception e){e.printStackTrace();}
	}
	
	private static final String RULE_TYPES_DB_FILE_PATH = "Databases\\RuleTypesDB.xml";
	
	
	private static RuleManager instance;
	private static DefaultMutableTreeNode rules;
	
	public static RuleManager getInstance(){
		if(instance == null)
			instance = new RuleManager();
		return instance;
	}
	
	private ArrayList<RuleType> ruleTypes;
	
	public RuleManager(){
		loadRuleTypes();
	}
	
	private void loadRuleTypes(){
		File xmlFile = new File(RULE_TYPES_DB_FILE_PATH);
		SAXBuilder builder = new SAXBuilder();
		ruleTypes = new ArrayList<RuleType>();
		try{
			Document document = (Document) builder.build(xmlFile);
			Element rootElement = document.getRootElement();
			List<Element> typeElements = rootElement.getChildren("type");
			for(Element typeElement: typeElements){
				String name = typeElement.getAttributeValue("name");
				ruleTypes.add(new RuleType(name));
			}
		}catch(Exception e){e.printStackTrace();}
	}
	
	public static DefaultMutableTreeNode getRules(File root){
		if(rules == null){
			rules = FileToRule(root);
		}
		
		return rules;
	}
	
	public ArrayList<RuleType> getRuleTypes(){
		return ruleTypes;
	}
	
	private static DefaultMutableTreeNode FileToRule(File root){
		DefaultMutableTreeNode dir;
		
		DefaultMutableTreeNode item;
			
		if(root.isDirectory()){
			dir = new DefaultMutableTreeNode(root.getName());
			File[] files = root.listFiles();
			
			for(File file : files){	
				if(root.isFile()){
					item = new DefaultMutableTreeNode(new Rule(file));
					dir.add(item);
				}
				else{
					dir.add(FileToRule(file));
				}
			}
		}
		else{
			dir= new DefaultMutableTreeNode(new Rule(root));
		}
		
		return dir;
	}
	
	
}
