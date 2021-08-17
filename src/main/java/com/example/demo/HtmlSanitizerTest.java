package com.example.demo;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.owasp.html.PolicyFactory;
import org.owasp.html.Sanitizers;

public class HtmlSanitizerTest {
	private final static String FILE_PATH = "C:\\Dev\\projectdocs\\harmony\\Freemarker Scripts";
	
	public static void main(String[] args) {
		PolicyFactory sanitizer = Sanitizers.FORMATTING.and(Sanitizers.BLOCKS).and(Sanitizers.IMAGES).and(Sanitizers.LINKS).and(Sanitizers.STYLES).and(Sanitizers.TABLES);
		String htmlString = readFileAsString(FILE_PATH + "\\Airbus_TXN_Loop.txt");
		//String htmlString = "<div onclick=\"alert('hello');\">Hello ${firstname}<img src=\"https://www.clarionav.com/wp-content/uploads/logos.jpg\" onerror=\"alert('Hi');\"></div>";
		String sanitizedString = sanitizer.sanitize(htmlString);
		if (!htmlString.equals(sanitizedString)) {
			System.out.println(sanitizedString);
		} else {
			System.out.println("GOOD");
		}
	}
	
	private static String readFileAsString(String filePath)
	{
	    String content = "";
	    try
	    {
	        content = new String ( Files.readAllBytes(Paths.get(filePath)), Charset.forName("UTF-8") );
	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    return content;
	}
}
