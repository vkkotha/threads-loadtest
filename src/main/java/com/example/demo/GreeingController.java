package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GreeingController {
	@Autowired
	private GreetingService greetingService;
	private static final Logger logger = LoggerFactory.getLogger(GreeingController.class);
	
	private static RequestStats stats = new RequestStats();
	
	@GetMapping("/greeting")
	@ResponseBody
	public String greeting(@RequestParam String greeting, HttpServletRequest req, HttpServletResponse resp) {
		StopWatch watch = new StopWatch();
		watch.start();
		greetingService.longRequest();
		watch.stop();
		stats.setStats(watch.getElapsed());
		logger.info("Greeting request finished in {}", watch.getElapsedDuration());
		return "Hello " + greeting;
	}
	
	@GetMapping("/resetStats") 
	@ResponseBody
	public RequestStats resetStats() {
		stats.reset();
		return stats;
	}
	
	@GetMapping("/showStats")
	@ResponseBody
	public RequestStats showtStats() {
		return stats;
	}
}
