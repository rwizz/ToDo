package UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController implements ActionListener{
	public GuiController() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Neuer Task wird vom Gui erstellt
		if(e.getSource()==Gui.btn_newTask) {
			new TaskGui();
		}
		
	}

}