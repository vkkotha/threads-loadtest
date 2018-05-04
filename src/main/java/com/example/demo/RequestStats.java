package com.example.demo;

public class RequestStats {
	private Long maxtime;
	private Long mintime;
	private Long totaltime;
	private Long numRequests;
	
	public RequestStats() { }
	
	synchronized public void reset() {
		this.maxtime = null;
		this.mintime = null;
		this.totaltime = null;
		this.numRequests = null;
	}
	
	synchronized public void setStats(long time) {
		// set mintime
		if (mintime == null) {
			mintime = time;
		} else if (time < this.mintime) {
			mintime = time;
		}

		// set maxtime
		if (maxtime == null) {
			maxtime = time;
		} else if (time > this.maxtime) {
			maxtime = time;
		}
		
		// set Number of Requests
		if (numRequests == null) {
			numRequests = 1L;
		} else {
			numRequests += 1; 
		}
		
		// set total time
		if (totaltime == null) {
			totaltime = time;
		} else {
			totaltime += time;
		}
	}

	public long getMaxtime() {
		return maxtime == null ? 0: maxtime;
	}

	public long getMintime() {
		return mintime == null? 0: mintime;
	}
	
	public float getAvgtime() {
		return numRequests == null ? 0: totaltime / numRequests; 
	}
}
