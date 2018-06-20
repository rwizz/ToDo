package Data;

import java.util.ArrayList;

import BusinessLogic.TaskManager;
import DTO.Task;

public class DataIM extends Controller{
static Task[] arrTask=new Task[1000];//Anzahl Tasks
	@Override
	public void insert(Task createdTask) {
		//Der Mitgegebene Task wird in die ArrayList gespeichert
		arrTask[TaskManager.anzTask]=new Task() {};
		arrTask[TaskManager.anzTask].setId(TaskManager.anzTask);
		arrTask[TaskManager.anzTask].setTitle(createdTask.getTitle());
		arrTask[TaskManager.anzTask].setTimeCreated(createdTask.getTimeCreated());
		arrTask[TaskManager.anzTask].setDay(createdTask.getDay());
		arrTask[TaskManager.anzTask].setMonth(createdTask.getMonth());
		arrTask[TaskManager.anzTask].setYear(createdTask.getYear());
		arrTask[TaskManager.anzTask].setHour(createdTask.getHour());
		arrTask[TaskManager.anzTask].setMinute(createdTask.getMinute());
		arrTask[TaskManager.anzTask].setFavorite(createdTask.getFavorite());
	}
	@Override
		public Task[] getAllTasks() {
		//ArrayList wird zurückgegeben
			return(arrTask);
		}

}