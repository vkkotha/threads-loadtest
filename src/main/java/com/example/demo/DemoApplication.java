package com.example.demo;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Value("${server.tomcat.acceptor-thread-count:1}")
	private int tomcat_acceptor_thread_count;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	@Bean
	public TomcatServletWebServerFactory tomcatEmbeddedServletContainerFactory() {
		TomcatServletWebServerFactory tomcatFactory = new TomcatServletWebServerFactory();

	    tomcatFactory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
	        @Override
	        public void customize(Connector connector) {
	            //tomcat default nio connector
	            Http11NioProtocol handler = (Http11NioProtocol)connector.getProtocolHandler();
	            //acceptCount is backlog, default value is 100, you can change which you want value in here
	            handler.setAcceptorThreadCount(tomcat_acceptor_thread_count);
	        }
	    });

	    return tomcatFactory;
	}
}
