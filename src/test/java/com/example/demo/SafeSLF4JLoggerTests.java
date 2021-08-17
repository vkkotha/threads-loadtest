package com.example.demo;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SafeSLF4JLoggerTests {
	private static final Logger logger = new SafeSLF4JLogger(LoggerFactory.getLogger(SafeSLF4JLoggerTests.class));
	private static final org.apache.logging.log4j.Logger logger1 = org.apache.logging.log4j.LogManager.getLogger(SafeSLF4JLoggerTests.class);

	@Test
	public void null_string() {
		String htmlWithJavascript = "<html>\n<head>\n\r<script>alert('Hello');</script></head></html>";
		// logger.info("Hello\n Universe: {}", htmlWithJavascript);
		logger1.info("Hello\n Universe: {}", htmlWithJavascript);
		logger1.info("Hello\n SpaceH: {}", htmlWithJavascript);

		/*
		Object x = null;
		logger.info("{}", x);
		logger1.info("{}", x);
		
		logger.info("Hello {}", "world");
		logger1.info("Hello {}", "world");
		
		logger.info("Hello {}", "world\nwide Org\n FATAL");
		logger1.info("Hello {}", "world\nwide Org\n FATAL");
		
		String htmlWithJavascript = "<html><head><script>alert('Hello');</script></head></html>";
		logger.info("Hello {}", htmlWithJavascript);
		logger1.info("Hello {}", htmlWithJavascript);
		
		logger.error("Hello {}", new IllegalArgumentException("abc"));
		logger1.error("Hello {}", new IllegalArgumentException("abc"));
		
		logger.info("Hello {} - {}", 123, 45.45f);
		logger1.info("Hello {} - {}", 123, 45.45f);
		
		StringBuffer buf = new StringBuffer();
		buf.append("{"
				+ "	\"abc\": \"xyz\","
				+ "	\"kkk\": \"123\""
				+ "}");
		logger.info("{}", buf.toString());
		logger1.info("{}", buf.toString());
		*/
	}
}
