package DTO;

import java.sql.Timestamp;

public abstract class Task {
int id;
String title;
Timestamp TimeCreated;
Boolean status;
int TimeFinish;
Boolean favorite;
	
	public Task() {
		
	}
	public Task(int id,String title,Timestamp TimeCreated,Boolean status,int TimeFinish,Boolean favorite) {
		setId(id);
		setTitle(title);
		setTimeCreated(TimeCreated);
		setStatus(status);
		setTimeFinish(TimeFinish);
		setFavorite(favorite);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getTimeCreated() {
		return TimeCreated;
	}
	public void setTimeCreated(Timestamp timeCreated) {
		TimeCreated = timeCreated;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getTimeFinish() {
		return TimeFinish;
	}
	public void setTimeFinish(int timeFinish) {
		TimeFinish = timeFinish;
	}
	public Boolean getFavorite() {
		return favorite;
	}
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
	
}