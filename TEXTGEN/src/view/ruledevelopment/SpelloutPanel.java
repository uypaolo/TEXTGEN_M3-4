package view.ruledevelopment;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SpelloutPanel extends JPanel{

	private JPanel panel1;
	private JPanel panel2;
	private JComboBox<String> spelloutValues;
	private String spelloutValueTitle;
	
	public SpelloutPanel(){
		this.setBorder(BorderFactory.createTitledBorder("Spellout Rules"));
		panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.PAGE_AXIS));
		
		spelloutValues = new JComboBox<String>();
		spelloutValues.setAlignmentX(java.awt.Component.LEFT_ALIGNMENT);
		spelloutValues.setMinimumSize(new Dimension(200,20));
		spelloutValues.setMaximumSize(new Dimension(200,20));
		
		this.setBorder(BorderFactory.createTitledBorder(spelloutValueTitle));
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));
	}
	
	public void intializeComp(){
		spelloutValues.setEnabled(true);
	}
	
	private String getSelectedFeatInCmb(){
		return spelloutValues.getSelectedItem().toString();
	}
	
	public void initializeSpellOutValues(){
		spelloutValues.addItem("Simple");
		spelloutValues.addItem("Table");
		spelloutValues.addItem("Morphophonemic");
		spelloutValues.addItem("Form Selection");
		spelloutValues.addItem("Phrase Builder");
	}
	
	
}
