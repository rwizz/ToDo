package Data;

import java.util.ArrayList;

import DTO.Task;

public class DataIM extends Controller{
static ArrayList<Task> arrTask=new ArrayList<>();
	
	@Override
	public void insert(Task createdTask) {
		arrTask.add(createdTask);
		System.out.println(createdTask.getTitle());
	}
	@Override
		public ArrayList<Task> getAllTasks() {
			return(arrTask);
		}

}