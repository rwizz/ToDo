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
				System.out.println(tm.loadData()[i].getFavorite()+" / "+tm.loadData()[i].getId()+" / "+tm.loadData()[i].getTitle()+" / "+tm.loadData()[i].getTimeCreated()+" / "+tm.loadData()[i].getStatus()+" / "+tm.loadData()[i].getDay()+"  "+tm.loadData()[i].getMonth()+"  "+tm.loadData()[i].getYear()+" / "+tm.loadData()[i].getHour()+"  "+tm.loadData()[i].getMinute());
//				
			}
		}
		//Favorisierte Task Werden Ausgegeben
		if(e.getSource()==Gui.btn_favorites) {
			tm.loadFavData();
			for(int i=0;i<tm.anzFavTask;i++) {
				System.out.println(tm.returnFavData()[i].getFavorite()+" / "+tm.returnFavData()[i].getId()+" / "+tm.returnFavData()[i].getTitle()+" / "+tm.returnFavData()[i].getTimeCreated()+" / "+tm.returnFavData()[i].getStatus()+" / "+tm.returnFavData()[i].getDay()+"  "+tm.returnFavData()[i].getMonth()+"  "+tm.returnFavData()[i].getYear()+" / "+tm.returnFavData()[i].getHour()+"  "+tm.returnFavData()[i].getMinute());
			}
		}
		
		//Aktion die Passiert wenn der Button Comfirm gedrückt wird
		if(e.getSource()==TaskGui.btn_confirm) {
			
			//es wird überprüft ob der erstellte Task favorisiert sein soll odder nicht
			if(TaskGui.btn_favyes.isSelected()) {
				fav=true;
			}else if(TaskGui.btn_favno.isSelected()) {
				fav=false;
			}
			//task wird erstllt und an Task Manager weitergegeben
			tm.createTask(TaskGui.txt_titel.getText(), Integer.parseInt(TaskGui.tagAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.monatAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.jahrAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.stundeAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.minuteAuswahl.getSelectedItem().toString()), fav);
			tm.anzTask+=1;
			TaskGui.reset();
		}
		
		if(e.getSource()==TaskGui.btn_cancel) {
			TaskGui.reset();
			TaskGui.jf.setVisible(false);
		}
		
	}

}