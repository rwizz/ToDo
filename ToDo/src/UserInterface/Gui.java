package UserInterface;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Gui extends JFrame{
	GuiController gc=new GuiController();
	
	//Jframe definiert
	static JFrame jf=new JFrame();
	
	//Definition Button
//	static JButton btn_favorites,btn_all,btn_closed,btn_newTask; --- F�r Status sp�ter
	static JButton btn_favorites,btn_all,btn_newTask;
//	static JButton btn_setState;
	
	//JPanel definitions
	JPanel pnl_gui=new JPanel();
	JPanel pnl_Menu;
	
	//JLabel definition
	JLabel lbl_titel;
	
	//JTabel Componenten
	static JTable tbl_task=new  JTable(new DefaultTableModel(new Object[]{"Favorite","ID","Titel","Date of Creation","Date to Finish"},0));
	String[] tbl_titel= {"Favorite","ID","Titel","Date of Creation","Date to Finish"};
	//Default TableModel bekommen
	static DefaultTableModel model=(DefaultTableModel) tbl_task.getModel();
	//JScroll pane inizierts
	JScrollPane scrollPanel;
			
	public Gui() {
		
		jf.setLayout(new BorderLayout());
		jf.setSize(1000, 95);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Grunds�tzlicher Aufbau----------------------------------
		pnl_gui.setLayout(new BorderLayout());
		lbl_titel=new JLabel("To Don't",JLabel.CENTER);
		pnl_gui.add(lbl_titel, BorderLayout.NORTH);
		btn_newTask=new JButton("new Task");
		btn_newTask.addActionListener(gc);
		pnl_gui.add(btn_newTask, BorderLayout.SOUTH);
		btn_favorites=new JButton("Favorites");
		btn_favorites.addActionListener(gc);
		btn_all=new JButton("All");
		btn_all.addActionListener(gc);
//		btn_closed=new JButton("Closed"); --- F�r Status sp�ter
//		btn_closed.addActionListener(gc); --- F�r Status sp�ter
		
		pnl_Menu=new JPanel();
//		pnl_Menu.setLayout(new GridLayout(1,3)); --- F�r Status sp�ter
		pnl_Menu.setLayout(new GridLayout(1,2));
		pnl_Menu.add(btn_favorites);
		pnl_Menu.add(btn_all);
//		pnl_Menu.add(btn_closed); --- F�r Status sp�ter
		
		pnl_gui.add(pnl_Menu,BorderLayout.CENTER);
		jf.add(pnl_gui,BorderLayout.NORTH);
		//Grunds�tzlicher Aufbau ende ------------------------
		
		//Darstellung Task angfang
		scrollPanel=new JScrollPane(tbl_task);
		jf.add(scrollPanel, BorderLayout.CENTER);
		
		tbl_task.setAutoCreateRowSorter(true);
//		btn_setState=new JButton("Status�nderungen �bernehmen"); --- F�r Status sp�ter
//		btn_setState.addActionListener(gc); --- F�r Status sp�ter
//		add(btn_setState, BorderLayout.SOUTH); --- F�r Status sp�ter
		jf.setVisible(true);
	}
	

}