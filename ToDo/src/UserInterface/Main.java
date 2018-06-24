package UserInterface;

import BusinessLogic.ReminderThread;

public class Main {
public static ReminderThread rth=new ReminderThread();
	
	public static void main(String[] args) {		
		new Gui();
		rth.start();
		new TaskGui();
		TaskGui.reset();
	}

}
