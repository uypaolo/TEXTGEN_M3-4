package controller.listener.lexicon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.MainController;

import view.MainFrame;
import view.lexicon.LexiconPanel;

public class MenuLexiconListener implements ActionListener {

	private MainController mainController;
	
	public MenuLexiconListener(MainController mainController){
		this.mainController = mainController;
	}
	
	public void actionPerformed(ActionEvent e) {
		mainController.goToLexicon();
	}
}
