package rule;

import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class RuleCreationWindow extends JFrame{
	private ButtonGroup cbg;
	private JComboBox<String> ruleType;
	private JComboBox<String> syntacticCategory;
	private JPanel creationGUI;
	private JPanel mainArea;
	private JLabel ruleNameLabel;
	private JLabel ruleTypeLabel;
	private JLabel syntacticCategoryLabel;
	private JTextField ruleName;
	private JCheckBox forAll;
	private JCheckBox specific;
	private JCheckBox global;
	
	public RuleCreationWindow(){
		setLayout(new MigLayout());
		initComponents();
		setFrame();
	}
	
	public void initComponents(){
		cbg = new ButtonGroup();
		mainArea = new JPanel();
		creationGUI = new JPanel();
		
		
		ruleNameLabel = new JLabel("Rule Name");
		ruleTypeLabel = new JLabel("Rule Type");
		syntacticCategoryLabel = new JLabel("Symantic Category");
		
		ruleType = new JComboBox<String>();
		ruleType.addItem("Structure");
		ruleType.addItem("Spell-out");
		ruleType.addItem("Feature Copy");
		
		syntacticCategory = new JComboBox<String>();
		syntacticCategory.addItem("Noun");
		syntacticCategory.addItem("Verb");
		syntacticCategory.addItem("Adjective");
		syntacticCategory.addItem("Adverb");
		syntacticCategory.addItem("Adposition");
		syntacticCategory.addItem("Conjunction");
		syntacticCategory.addItem("Phrasal");
		syntacticCategory.addItem("Particle");
		syntacticCategory.addItem("Noun Phrase");
		syntacticCategory.addItem("Verb Phrase");
		syntacticCategory.addItem("Adjective Phrase");
		syntacticCategory.addItem("Adverb Phrase");
		syntacticCategory.addItem("Clause");
		
		ruleName = new JTextField();
		forAll = new JCheckBox("On/Off for document", false);
		specific = new JCheckBox("On/Off for selected", false);
		global = new JCheckBox("On/Off", true);
		
		cbg.add(forAll);
		cbg.add(specific);
		cbg.add(global);
		
		mainArea.add(ruleTypeLabel);
		mainArea.add(ruleType);
		mainArea.add(syntacticCategoryLabel);
		mainArea.add(syntacticCategory);
		mainArea.add(ruleNameLabel);
		mainArea.add(ruleName);
		mainArea.add(forAll);
		mainArea.add(specific);
		mainArea.add(global);
		mainArea.add(creationGUI);
		
		add(mainArea);
	}
	
	public void setFrame(){
		this.setTitle("Rule Creation");
		this.setSize(750, 545);//640
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setBackground(Color.DARK_GRAY);
		this.pack();
	}
}
