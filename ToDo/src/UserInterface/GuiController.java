package UserInterface;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import BusinessLogic.ReminderThread;

public class GuiController implements ActionListener{
BusinessLogic.TaskManager tm=new BusinessLogic.TaskManager();
Boolean fav,complete;
public String timefinish;
	public GuiController() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Neuer Task wird vom Gui erstellt
		if(e.getSource()==Gui.btn_newTask) {
			TaskGui.jf.setState(JFrame.NORMAL);
			
		}
		//Alle Tasks werden ausgegeben
		if(e.getSource()==Gui.btn_all) {
			Gui.jf.setSize(1000,500);
			Gui.model.setRowCount(0);//Tabelle wird auf zeile 0 gesetzt und somit �berschrieben
			for(int i=0;i<tm.anzTask;i++) {
//konsole		System.out.println(tm.loadData()[i].getFavorite()+" / "+tm.loadData()[i].getId()+" / "+tm.loadData()[i].getTitle()+" / "+tm.loadData()[i].getTimeCreated()+" / "+tm.loadData()[i].getStatus()+" / "+tm.loadData()[i].getDay()+"  "+tm.loadData()[i].getMonth()+"  "+tm.loadData()[i].getYear()+" / "+tm.loadData()[i].getHour()+"  "+tm.loadData()[i].getMinute());
				timefinish=tm.loadData()[i].getDay()+"-"+tm.loadData()[i].getMonth()+"-"+tm.loadData()[i].getYear()+" "+tm.loadData()[i].getHour()+":"+tm.loadData()[i].getMinute();
				Gui.model.addRow(new Object[] {tm.loadData()[i].getFavorite(),tm.loadData()[i].getId(),tm.loadData(
						)[i].getTitle(),tm.loadData()[i].getTimeCreated(),timefinish});
			}
		}
		//Favorisierte Task Werden Ausgegeben
		if(e.getSource()==Gui.btn_favorites) {
			Gui.jf.setSize(1000,500);
			tm.loadFavData();
			Gui.model.setRowCount(0);//Tabelle wird auf zeile 0 gesetzt und somit �berschrieben
			for(int i=0;i<tm.anzFavTask;i++) {
//konsole		System.out.println(tm.returnFavData()[i].getFavorite()+" / "+tm.returnFavData()[i].getId()+" / "+tm.returnFavData()[i].getTitle()+" / "+tm.returnFavData()[i].getTimeCreated()+" / "+tm.returnFavData()[i].getStatus()+" / "+tm.returnFavData()[i].getDay()+"  "+tm.returnFavData()[i].getMonth()+"  "+tm.returnFavData()[i].getYear()+" / "+tm.returnFavData()[i].getHour()+"  "+tm.returnFavData()[i].getMinute());
				timefinish=tm.returnFavData()[i].getDay()+"-"+tm.returnFavData()[i].getMonth()+"-"+tm.returnFavData()[i].getYear()+" "+tm.returnFavData()[i].getHour()+":"+tm.returnFavData()[i].getMinute();
				Gui.model.addRow(new Object[] {tm.returnFavData()[i].getFavorite(),tm.returnFavData()[i].getId(),tm.returnFavData()[i].getTitle(),tm.returnFavData()[i].getTimeCreated(),timefinish});
			}
		}
		
		//Aktion die Passiert wenn der Button Comfirm gedr�ckt wird
		if(e.getSource()==TaskGui.btn_confirm) {
			if (TaskGui.txt_titel.getText().isEmpty()) {
				TaskGui.lbl_titel.setForeground(Color.red);
				complete=false;
			}else {
				TaskGui.lbl_titel.setForeground(Color.black);
				complete=true;
			}
			
			//es wird �berpr�ft ob der erstellte Task favorisiert sein soll odder nicht
			if(TaskGui.btn_favyes.isSelected()) {
				TaskGui.lbl_titel.setForeground(Color.black);
				fav=true;
				complete=true;
			}else if(TaskGui.btn_favno.isSelected()) {
				TaskGui.lbl_titel.setForeground(Color.black);
				fav=false;
				complete=true;
			}else {
				TaskGui.lbl_favorite.setForeground(Color.red);
				complete=false;
			}
			if(complete==true) {
			//task wird erstllt und an Task Manager weitergegeben
			tm.createTask(TaskGui.txt_titel.getText(), Integer.parseInt(TaskGui.tagAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.monatAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.jahrAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.stundeAuswahl.getSelectedItem().toString()), Integer.parseInt(TaskGui.minuteAuswahl.getSelectedItem().toString()), fav);
			tm.anzTask+=1;
			TaskGui.reset();	
			}
			
		}
		
		//Wenn Knopf Cancel gedr�ckt wird
		if(e.getSource()==TaskGui.btn_cancel) {
			TaskGui.reset();
		}
		//Knopf um den ge�nderten Status zu �bernehmen --- F�r Status sp�ter
//		if(e.getSource()==Gui.btn_setState) {
//			
//		}
		
	}

}