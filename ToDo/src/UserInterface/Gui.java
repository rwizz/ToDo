package UserInterface;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui extends JFrame{
	GuiController gc=new GuiController();
	JFrame jf_gui=new JFrame();
	JButton btn_favorites,btn_all,btn_closed,btn_newTask;
	JPanel pnl;
	JLabel titel;
	
	public Gui() {
		jf_gui.setSize(500,150);
		jf_gui.setLayout(new BorderLayout());
		jf_gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titel=new JLabel("To Don't",JLabel.CENTER);
		jf_gui.add(titel, BorderLayout.NORTH);
		btn_newTask=new JButton("new Task");
		btn_newTask.addActionListener(gc);
		jf_gui.add(btn_newTask, BorderLayout.SOUTH);
		
		btn_favorites=new JButton("Favorites");
		btn_favorites.addActionListener(gc);
		btn_all=new JButton("All");
		btn_all.addActionListener(gc);
		btn_closed=new JButton("Closed");
		btn_closed.addActionListener(gc);
		
		pnl=new JPanel();
		pnl.setLayout(new GridLayout(1,3));
		pnl.add(btn_favorites);
		pnl.add(btn_all);
		pnl.add(btn_closed);
		
		jf_gui.add(pnl,BorderLayout.CENTER);
		
		
		jf_gui.setVisible(true);
	}

}