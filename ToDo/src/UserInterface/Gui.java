package UserInterface;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame{
	GuiController gc=new GuiController();
	
	//Definition Button
	static JButton btn_favorites,btn_all,btn_closed,btn_newTask;
	
	//JPanel definitions
	JPanel pnl_gui=new JPanel();
	JPanel pnl_Menu;
	
	//JLabel definition
	JLabel titel;
			
	public Gui() {
		setLayout(new BorderLayout());
		setSize(500, 150);
		//Grundsätzlicher Aufbau----------------------------------
		pnl_gui.setLayout(new BorderLayout());
		
		titel=new JLabel("To Don't",JLabel.CENTER);
		pnl_gui.add(titel, BorderLayout.NORTH);
		btn_newTask=new JButton("new Task");
		btn_newTask.addActionListener(gc);
		pnl_gui.add(btn_newTask, BorderLayout.SOUTH);
		
		btn_favorites=new JButton("Favorites");
		btn_favorites.addActionListener(gc);
		btn_all=new JButton("All");
		btn_all.addActionListener(gc);
		btn_closed=new JButton("Closed");
		btn_closed.addActionListener(gc);
		
		pnl_Menu=new JPanel();
		pnl_Menu.setLayout(new GridLayout(1,3));
		pnl_Menu.add(btn_favorites);
		pnl_Menu.add(btn_all);
		pnl_Menu.add(btn_closed);
		
		pnl_gui.add(pnl_Menu,BorderLayout.CENTER);
		add(pnl_gui,BorderLayout.NORTH);
		//Grundsätzlicher Aufbau ende ------------------------
		
		//Darstellung Task angfang
		
		setVisible(true);
	}

}