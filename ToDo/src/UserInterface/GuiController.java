package UserInterface;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiController implements ActionListener{
BusinessLogic.TaskManager tm=new BusinessLogic.TaskManager();
Boolean fav;
public static int anzTask=0; //Anzahl aller Tasks
	public GuiController() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Neuer Task wird vom Gui erstellt
		if(e.getSource()==Gui.btn_newTask) {
			TaskGui.jf.setVisible(true);
			new TaskGui();
		}
		//Alle Tasks werden ausgegeben
		if(e.getSource()==Gui.btn_all) {
			for(int i=0;i<anzTask;i++) {
				System.out.println(tm.loadData().get(i).getTitle());
			}
		}
		if(e.getSource()==TaskGui.btn_confirm) {
			if(TaskGui.btng_fav.getSelection()==TaskGui.btn_favyes) {
				fav=true;
			}else if(TaskGui.btng_fav.getSelection()==TaskGui.btn_favno) {
				fav=false;
			}
			tm.createTask(TaskGui.txt_titel.getText(), TaskGui.tagAuswahl.getSelectedIndex(), TaskGui.monatAuswahl.getSelectedIndex(), TaskGui.jahrAuswahl.getSelectedIndex(), TaskGui.stundeAuswahl.getSelectedIndex(), TaskGui.minuteAuswahl.getSelectedIndex(), fav);
			anzTask+=1;
			TaskGui.reset();
		}
		
	}

}