package DTO;

import java.sql.Timestamp;

public abstract class Task {
int id;
String title;
Timestamp TimeCreated;
Boolean status;
int day;
int month;
int year;
int hour;
int minute;
Boolean favorite;
	
	public Task() {
		
	}
	public Task(int id,String title,Timestamp TimeCreated,Boolean status,int day,int month,int year,int hour,int minute,Boolean favorite) {
		setId(id);
		setTitle(title);
		setTimeCreated(TimeCreated);
		setStatus(status);
		setDay(day);
		setMonth(month);
		setYear(year);
		setHour(hour);
		setMinute(minute);
		setFavorite(favorite);
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
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
	public Boolean getFavorite() {
		return favorite;
	}
	public void setFavorite(Boolean favorite) {
		this.favorite = favorite;
	}
	
}