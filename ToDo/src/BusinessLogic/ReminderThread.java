package BusinessLogic;

import java.time.LocalTime;

import javax.swing.JOptionPane;

public class ReminderThread extends Thread{
LocalTime time;
Boolean bevor=true;
static JOptionPane[] arrPne=new JOptionPane[1000];
	public void run(){
		//Wartet auf den Nächsten Zeitpunkt wo die Sekunden 59 betragen
		while(bevor==true) {
			time=LocalTime.now();
			if(time.getSecond()==59) {
				bevor=false;
				try {
					sleep(1000);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		//überprüft alle ob einer der Favorisierten Tasks jetzt beendet werden sollte und führ die Reminder Methode aus
		while(true) {
			
			time=LocalTime.now();
			int anzPne=0;
			TaskManager.loadFavData();
			for(int i=0;i<TaskManager.anzFavTask;i++) {
				if(TaskManager.returnFavData()[i].getHour()==time.getHour()) {
					if(TaskManager.returnFavData()[i].getMinute()==time.getMinute()) {
						arrPne[anzPne]=new JOptionPane();
						TaskManager.returnFavData()[i].reminder(arrPne[anzPne],TaskManager.returnFavData()[i].getTitle());
					}
				}
			}
			try {
				sleep(60000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	};
	
}