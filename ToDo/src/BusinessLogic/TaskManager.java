package BusinessLogic;



import java.sql.Timestamp;
import java.util.ArrayList;

import DTO.Task;
import Data.Controller;
import Data.DataIM;
import UserInterface.GuiController;

public class TaskManager {
	Task task=new Task() {};
	Data.DataIM ctrl=new Data.DataIM();
	
	//ArrayList der Favorisierten Tasks

	public static Task[] arrFavTask=new Task[1000];//Anzahl Tasks
	
	public static int anzTask=0; //Anzahl aller Tasks
	public static int anzFavTask=0; //Anzahl aller Favorisierten Tasks
	
	public TaskManager() {
	
		
	}
	
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
	
	public void loadFavData() {
		anzFavTask=0;
		for(int i=0;i<anzTask;i++) {
			if(ctrl.getAllTasks()[i].getFavorite()==true) {
				arrFavTask[i]=new Task() {};
				arrFavTask[i].setId(ctrl.getAllTasks()[i].getId());
				arrFavTask[i].setTitle(ctrl.getAllTasks()[i].getTitle());
				arrFavTask[i].setTimeCreated(ctrl.getAllTasks()[i].getTimeCreated());
				arrFavTask[i].setDay(ctrl.getAllTasks()[i].getDay());
				arrFavTask[i].setMonth(ctrl.getAllTasks()[i].getMonth());
				arrFavTask[i].setYear(ctrl.getAllTasks()[i].getYear());
				arrFavTask[i].setHour(ctrl.getAllTasks()[i].getHour());
				arrFavTask[i].setMinute(ctrl.getAllTasks()[i].getMinute());
				arrFavTask[i].setFavorite(ctrl.getAllTasks()[i].getFavorite());
				anzFavTask+=1;
			}
		}
	}
	public Task[] returnFavData() {
		return arrFavTask;
	}

}
