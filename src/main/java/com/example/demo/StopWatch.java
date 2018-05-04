package com.example.demo;

import lombok.Getter;

public class StopWatch {
	enum WatchState { RUNNING, STOPPED };

	@Getter private long stime;
	@Getter private long etime;
	@Getter private WatchState currentState = WatchState.STOPPED;
	@Getter private long elapsed;
	
	public StopWatch() {
	}
	
	public void start() {
		if (WatchState.STOPPED.equals(this.currentState)) {
			this.stime = System.currentTimeMillis();
			this.currentState = WatchState.RUNNING;
		}
	}
	
	public void stop() {
		if (WatchState.RUNNING.equals(this.currentState)) {
			this.etime = System.currentTimeMillis();
			this.elapsed = this.etime - this.stime;
			this.currentState = WatchState.STOPPED;
		}
	}

	public void reset() {
		this.stime = 0;
		this.etime = 0;
		this.currentState = WatchState.STOPPED;
		this.elapsed = 0;
	}
	
	public Duration getElapsedDuration() {
		return new Duration(this.elapsed);
	}
}
