package view.ruledevelopment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.tree.DefaultMutableTreeNode;

public class PopUpMenu extends JPopupMenu{
	private JMenuItem newFolder;
	private JMenuItem delete;
	private DefaultMutableTreeNode selectedNode;
	
	public PopUpMenu(){	
		newFolder = new JMenuItem("New Folder");
		newFolder.setMnemonic(KeyEvent.VK_E);
        newFolder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	String s = JOptionPane.showInputDialog("Folder Name");
            	
            }
        });
		
		delete = new JMenuItem("Delete");
	    add(newFolder);
	    add(delete);
	}
	
	public void setSelectedNode(DefaultMutableTreeNode node){
		this.selectedNode = node;
	}
	
	private void createFolder(String name){
		
	}
}
