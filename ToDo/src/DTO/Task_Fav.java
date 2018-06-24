package DTO;

import java.sql.Timestamp;

import javax.swing.JOptionPane;

	public class Task_Fav extends Task {
	static JOptionPane pne1;
		public Task_Fav() {
		
	}
		
		public Task_Fav(int id,String title,Timestamp TimeCreated,Boolean status,int day,int month,int year,int hour,int minute,Boolean favorite) {
		super(id,title,TimeCreated,status,day,month,year,hour,minute,favorite);
	}
	
	public static void reminder(JOptionPane pne,String titel) {
		pne.showMessageDialog(null,"Der Task mit dem Titel " +titel+ " muss abgeschlossen werden");
	}
}
