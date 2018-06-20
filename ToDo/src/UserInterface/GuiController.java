package UserInterface;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class GuiController implements ActionListener{
BusinessLogic.TaskManager tm=new BusinessLogic.TaskManager();
Boolean fav;

	public GuiController() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Neuer Task wird vom Gui erstellt
		if(e.getSource()==Gui.btn_newTask) {
			new TaskGui();
		}
		//Alle Tasks werden ausgegeben
		if(e.getSource()==Gui.btn_all) {
			for(int i=0;i<tm.anzTask;i++) {
//				System.out.println(tm.loadData().get(i).getTitle());
				System.out.println(tm.loadData()[i].getFavorite()+" / "+tm.loadData()[i].getId()+" / "+tm.loadData()[i].getTitle()+" / "+tm.loadData()[i].getTimeCreated()+" / "+tm.loadData()[i].getStatus()+" / "+tm.loadData()[i].getDay()+" / "+tm.loadData()[i].getMonth()+" / "+tm.loadData()[i].getYear()+" / "+tm.loadData()[i].getHour()+" / "+tm.loadData()[i].getMinute());
//				
			}
		}
		//Aktion die Passiert wenn der Button Comfirm gedrückt wird
		if(e.getSource()==TaskGui.btn_confirm) {
			
			//es wird überprüft ob der erstellte Task favorisiert sein soll odder nicht
			if(TaskGui.btng_fav.getSelection()==TaskGui.btn_favyes) {
				fav=true;
			}else if(TaskGui.btng_fav.getSelection()==TaskGui.btn_favno) {
				fav=false;
			}
			//task wird erstllt und an Task Manager weitergegeben
			tm.createTask(TaskGui.txt_titel.getText(), TaskGui.tagAuswahl.getSelectedIndex(), TaskGui.monatAuswahl.getSelectedIndex(), TaskGui.jahrAuswahl.getSelectedIndex(), TaskGui.stundeAuswahl.getSelectedIndex(), TaskGui.minuteAuswahl.getSelectedIndex(), fav);
			tm.anzTask+=1;
			TaskGui.reset();
		}
		
	}

}