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

import net.miginfocom.swing.MigLayout;

public class SpelloutPanel extends JPanel{

	private JPanel panel1;
	private JPanel panel2;
	private JLabel spelloutValueslabel;
	private JComboBox<String> spelloutValues;
	private String spelloutValueTitle;
	
	public SpelloutPanel(){
		panel1 = new JPanel();
		this.setBorder(BorderFactory.createTitledBorder("Spellout Rules"));
		this.setLayout(new MigLayout());
		
		spelloutValueslabel = new JLabel("Spellout Values");
		
		spelloutValues = new JComboBox<String>();
		initializeSpellOutValues();
		intializeComp();

		panel1.add(spelloutValueslabel);
		panel1.add(spelloutValues);
		
		panel1.setVisible(true);
		spelloutValues.setVisible(true);
		
	}
	
	public void intializeComp(){
		spelloutValues.setEnabled(true);
	}
	
	private String getSelectedSpelloutInCmb(){
		return spelloutValues.getSelectedItem().toString();
	}
	
	private void gotoSelectedSpellout(){
		String selected = getSelectedSpelloutInCmb();
		
		switch(selected){
			case "Simple":
			case "Table":
			case "Morphophonemic":
			case "Form Selection":
			case "Phrase Builder":
		}
	}
	
	private void initializeSpellOutValues(){
		spelloutValues.addItem("Simple");
		spelloutValues.addItem("Table");
		spelloutValues.addItem("Morphophonemic");
		spelloutValues.addItem("Form Selection");
		spelloutValues.addItem("Phrase Builder");
	}
	
}
