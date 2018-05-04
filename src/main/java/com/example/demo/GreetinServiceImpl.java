package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class GreetinServiceImpl implements GreetingService {

	@Override
	public void longRequest() {
		try {
			Thread.currentThread().sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
