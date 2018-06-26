package BusinessLogic;



import java.sql.Timestamp;
import java.util.ArrayList;

import DTO.Task;
import DTO.Task_Fav;
import Data.Controller;
import Data.DataIM;
import UserInterface.GuiController;

public class TaskManager {
	Task task=new Task() {};
	static Data.DataIM ctrl=new Data.DataIM();
	
	//ArrayList der Favorisierten Tasks

	public static Task_Fav[] arrFavTask=new Task_Fav[1000];//Anzahl Tasks
	
	public static int anzTask=0; //Anzahl aller Tasks
	public static int anzFavTask=0; //Anzahl aller Favorisierten Tasks
	
	public TaskManager() {
	
		
	}
	//Task wird erstellt und der Methode write Task weitergegeben
	public void createTask(String title,int day,int month,int year,int hour,int minute,Boolean favorite) {
		task.setId(anzTask);
		task.setTitle(title);
		Timestamp timeCreated=new Timestamp(System.currentTimeMillis());
		task.setTimeCreated(timeCreated);
		task.setDay(day);
		task.setMonth(month);
		task.setYear(year);
		task.setHour(hour);
		task.setMinute(minute);
		task.setFavorite(favorite);
		
		writeTask(task);
	}
	
	//Task wird an Controller weitergegeben
	private void writeTask(Task createdTask) {
		ctrl.insert(createdTask);
	}
	//bekommt Arraylist von Controller
	public Task[] loadData(){
		return ctrl.getAllTasks();
	}
	//Ladet alle Favoriten in die ArrayList
	public static void loadFavData() {
		anzFavTask=0;
		for(int i=0;i<anzTask;i++) {
			if(ctrl.getAllTasks()[i].getFavorite()==true) {
				arrFavTask[anzFavTask]=new Task_Fav() {};
				arrFavTask[anzFavTask].setId(ctrl.getAllTasks()[i].getId());
				arrFavTask[anzFavTask].setTitle(ctrl.getAllTasks()[i].getTitle());
				arrFavTask[anzFavTask].setTimeCreated(ctrl.getAllTasks()[i].getTimeCreated());
				arrFavTask[anzFavTask].setDay(ctrl.getAllTasks()[i].getDay());
				arrFavTask[anzFavTask].setMonth(ctrl.getAllTasks()[i].getMonth());
				arrFavTask[anzFavTask].setYear(ctrl.getAllTasks()[i].getYear());
				arrFavTask[anzFavTask].setHour(ctrl.getAllTasks()[i].getHour());
				arrFavTask[anzFavTask].setMinute(ctrl.getAllTasks()[i].getMinute());
				arrFavTask[anzFavTask].setFavorite(ctrl.getAllTasks()[i].getFavorite());
				anzFavTask+=1;
			}
		}
	}
	//Gibt die ArrayList mit den Favorisierten Tasks zurück
	public static Task_Fav[] returnFavData() {
		return arrFavTask;
	}

}
