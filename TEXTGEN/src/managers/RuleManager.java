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

public class RuleManager {
	
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
		DefaultMutableTreeNode dir = new DefaultMutableTreeNode();
		DefaultMutableTreeNode item;
			
		if(root.isDirectory()){
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
		else if(root.isFile()){
			item = new DefaultMutableTreeNode(new Rule(root));
			dir.add(item);
		}
		
		return dir;
	}
	
	
}
