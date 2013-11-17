package view.ruledevelopment;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import managers.FeatureManager;
import rule.RuleCreationWindow;
import view.grammardevelopment.DisplayScreen;
import view.grammardevelopment.editsemantics.CreationRightPanel;
import features.DBFeatureValues;

public class FeatureCopyPanel extends JPanel{
	private static final int FEATURE_COPY_MODE = 0;
	private static final int FEATURE_SETTING_MODE = 1;
	
	private CreationRightPanel creationPanel;
	private DisplayScreen inputScreen;
	private DisplayScreen outputScreen;
	private JPanel copyPanel;
	private JButton okButton;
	private JButton cancelButton;
	private JButton selectSRCDEST;
	private JScrollPane featureSelect;
	private JPanel featureSelectPanel;
	private JComboBox<String> featureToCopy;
	private JComboBox<String> defaultValue;
	private JTextField copyName;
	private JTextField comment;
	private LinkedHashMap<String, ArrayList<DBFeatureValues>> featureList;
	private ArrayList<DBFeatureValues> selectedFeature;
	
	public FeatureCopyPanel(){
		creationPanel = new CreationRightPanel();
		copyPanel = createCopyPanel();
		inputScreen = new DisplayScreen();
		this.add(inputScreen);
		this.add(copyPanel);
		this.add(creationPanel);
		
	}
	
	private JPanel createCopyPanel(){
		featureList = FeatureManager.getFeatureMap();
		selectedFeature = featureList.get(RuleCreationWindow.sc);
		System.out.println(featureList.keySet());
		System.out.println(RuleCreationWindow.sc);
		
		JPanel area = new JPanel();
		featureSelectPanel = new JPanel();
		
		selectSRCDEST = new JButton("Select source");
		
		defaultValue = new JComboBox<String>();

		featureToCopy = new JComboBox<String>();
		for(DBFeatureValues db: selectedFeature){
			featureToCopy.addItem(db.getFeatureName());
		}
		featureToCopy.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				updateValues(featureToCopy.getSelectedItem().toString());
			}
			
		});
		
		
		featureSelectPanel.add(selectSRCDEST);
		featureSelectPanel.add(featureToCopy);
		featureSelectPanel.add(defaultValue);
		//private JTextField copyName;
		//private JTextField comment;
		
		
		featureSelect = new JScrollPane(featureSelectPanel);
		featureSelect.setBorder(BorderFactory.createTitledBorder("Features to be copied"));
		
		area.add(featureSelect);
		
		return area;
	}
	
	private void updateValues(String selected){
		defaultValue.removeAllItems();
		for(DBFeatureValues db: selectedFeature){
			if(db.getFeatureName().equals(selected)){
				ArrayList<String> values = db.getValues();
				for(String s: values){
					defaultValue.addItem(s);
				}
			}
		}
	}
}
