package UserInterface;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Gui extends JFrame{
	GuiController gc=new GuiController();
	
	JButton btn_NewTask;
	
	public Gui() {
		setSize(500,500);
		
		btn_NewTask=new JButton("New Task");
		btn_NewTask.addActionListener(gc);
		add(btn_NewTask);
		
		setVisible(true);
	}

}
