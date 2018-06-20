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
public static int anzTask=0; //Anzahl aller Tasks
	
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
	
	

}
