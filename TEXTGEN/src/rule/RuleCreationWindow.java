package rule;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;
import view.ruledevelopment.FeatureCopyPanel;

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
	public static String sc;
	
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
		
		ruleType.setSelectedIndex(0);
		
		ruleType.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				// TODO Auto-generated method stub
				String selected = ((JComboBox)arg0.getSource()).getSelectedItem().toString();
				if(selected.equals("Spell-out")){
					//System.out.println("SPELLOUT!!!!!!!!!!!!!!!");
					Container parent = creationGUI.getParent();
					parent.remove(creationGUI);
					creationGUI = new FeatureCopyPanel();
					parent.add(creationGUI);
					parent.repaint();
					parent.revalidate();
					
				}
			}
			
		});
		
		syntacticCategory = new JComboBox<String>();
		syntacticCategory.addItem("N");
		syntacticCategory.addItem("V");
		syntacticCategory.addItem("Adj");
		syntacticCategory.addItem("Adv");
		syntacticCategory.addItem("Adp");
		syntacticCategory.addItem("Conj");
		syntacticCategory.addItem("Particle");
		syntacticCategory.addItem("NP");
		syntacticCategory.addItem("VP");
		syntacticCategory.addItem("AdjP");
		syntacticCategory.addItem("AdvP");
		syntacticCategory.addItem("Cl");
		
		sc = syntacticCategory.getSelectedItem().toString();
		
		syntacticCategory.setSelectedIndex(0);
		
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
