package com.nolan.tom.raspi.Logic;

import java.sql.Date;

public class Notification {
	
	private String videoId ;
	private Date dateTime ;
	private int duration ;
	private String camId ;
	
	public Notification(String videoId, Date dateTime, int duration, String camId)
	{
		this.setVideoId(videoId);
		this.setDateTime(dateTime);
		this.setDuration(duration);
		this.setCamId(camId);
	}
	
	public String getVideoId() {
		return videoId;
	}
	private void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	private void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public int getDuration() {
		return duration;
	}
	private void setDuration(int duration) {
		this.duration = duration;
	}
	public String getCamId() {
		return camId;
	}
	private void setCamId(String camId) {
		this.camId = camId;
	}
	
}
