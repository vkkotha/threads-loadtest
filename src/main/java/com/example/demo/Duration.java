package com.example.demo;

import lombok.Data;

@Data
public class Duration {
	private long interval;
	private int millis;
	private int seconds;
	private int minutes;
	private int hours;
	private int days;
	
	public Duration(long interval) {
		this.setInterval(interval);
	}
	
	public void setInterval(long interval) {
		this.interval = interval;
		this.setMillis((int)interval % 1000);
		
		long elapsedSecs = interval / 1000;
		this.setSeconds((int)elapsedSecs % 60);
		
		long elapsedMins = elapsedSecs / 60;
		this.setMinutes((int)elapsedMins % 60);
		
		long elapsedHours = elapsedMins / 60;
		this.setHours((int)elapsedHours % 24);
		
		this.setDays((int)elapsedHours / 24);
	}
}
