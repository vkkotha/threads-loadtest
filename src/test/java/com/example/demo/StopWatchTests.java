package com.example.demo;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StopWatchTests {
	@Test
	public void testStart() {
		StopWatch watch = new StopWatch();
		watch.start();
		
		assertEquals("state", StopWatch.WatchState.RUNNING, watch.getCurrentState());
		assertThat("starttime", Long.valueOf(watch.getStime()), greaterThan(0l));
		assertThat("starttime", Long.valueOf(watch.getStime()), lessThanOrEqualTo(System.currentTimeMillis()));
		assertEquals("endtime", 0, watch.getEtime());
		assertEquals("elapsed",watch.getElapsed(), 0);
		assertNotNull("duration", watch.getElapsedDuration());
	}

	@Test
	public void testStop() {
		StopWatch watch = new StopWatch();
		watch.start();
		pause(1000);
		watch.stop();
		
		assertEquals("state", StopWatch.WatchState.STOPPED, watch.getCurrentState());
		assertThat("starttime", Long.valueOf(watch.getStime()), greaterThan(0l));
		assertThat("endtime greater than starttime", new Long(watch.getEtime()), greaterThan(Long.valueOf(watch.getStime())));
		assertThat("elapsed greater than 0", Long.valueOf(watch.getElapsed()), greaterThan(0l));
		assertNotNull("duration", watch.getElapsedDuration());
		assertThat("duration interval greater than 0", Long.valueOf(watch.getElapsedDuration().getInterval()), greaterThan(0l));
		assertThat("duration seconds greater than or equal to 1", Integer.valueOf(watch.getElapsedDuration().getSeconds()), greaterThanOrEqualTo(1));
	}
	
	@Test
	public void testReset() {
		StopWatch watch = new StopWatch();
		watch.start();
		pause(1000);
		watch.reset();
		
		assertEquals("state", StopWatch.WatchState.STOPPED, watch.getCurrentState());
		assertEquals("starttime", watch.getStime(), 0);
		assertEquals("endtime", watch.getEtime(), 0);
		assertEquals("elapsed", watch.getElapsed(), 0);
		assertNotNull("duration", watch.getElapsedDuration());
		assertEquals("duration interval", watch.getElapsedDuration().getInterval(), 0);
	}
	
	private void pause(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}