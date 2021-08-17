package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DurationTests {
	@Test
	public void onlyMillis() {
		Duration duration = new Duration(100);
		
		assertEquals("interval",  100, duration.getInterval());
		assertEquals("milliseconds",  100, duration.getMillis());
		assertEquals("seconds",  0, duration.getSeconds());
		assertEquals("minutes",  0, duration.getMinutes());
		assertEquals("hours",  0, duration.getHours());
		assertEquals("days",  0, duration.getDays());
	}

	@Test
	public void timeInSeconds() {
		Duration duration = new Duration(1200);
		
		assertEquals("interval",  1200, duration.getInterval());
		assertEquals("milliseconds",  200, duration.getMillis());
		assertEquals("seconds",  1, duration.getSeconds());
		assertEquals("minutes",  0, duration.getMinutes());
		assertEquals("hours",  0, duration.getHours());
		assertEquals("days",  0, duration.getDays());
	}

	@Test
	public void timeInMinutes() {
		Duration duration = new Duration(62100);
		
		assertEquals("interval",  62100, duration.getInterval());
		assertEquals("milliseconds",  100, duration.getMillis());
		assertEquals("seconds",  2, duration.getSeconds());
		assertEquals("minutes",  1, duration.getMinutes());
		assertEquals("hours",  0, duration.getHours());
		assertEquals("days",  0, duration.getDays());
	}

	@Test
	public void timeInHours() {
		Duration duration = new Duration(10930400);
		
		assertEquals("interval",  10930400, duration.getInterval());
		assertEquals("milliseconds",  400, duration.getMillis());
		assertEquals("seconds",  10, duration.getSeconds());
		assertEquals("minutes",  2, duration.getMinutes());
		assertEquals("hours",  3, duration.getHours());
		assertEquals("days",  0, duration.getDays());
	}

	@Test
	public void timeInDays() {
		Duration duration = new Duration(518159999);
		
		assertEquals("interval",  518159999, duration.getInterval());
		assertEquals("milliseconds",  999, duration.getMillis());
		assertEquals("seconds",  59, duration.getSeconds());
		assertEquals("minutes",  55, duration.getMinutes());
		assertEquals("hours",  23, duration.getHours());
		assertEquals("days",  5, duration.getDays());
	}
}
