package BusinessLogic;

import java.time.LocalTime;

public class ReminderThread extends Thread{
LocalTime time;
Boolean bevor=true;
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
		
		while(true) {
			time=LocalTime.now();
			System.out.println("thread läuft"+time);
			System.out.println(time.getMinute());
			try {
				sleep(60000);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	};
	
}