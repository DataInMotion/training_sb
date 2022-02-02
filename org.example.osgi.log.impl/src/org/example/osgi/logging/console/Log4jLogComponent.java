package org.example.osgi.logging.console;

import org.example.osgi.logging.Log;
import org.osgi.service.component.annotations.Component;

@Component(property = {"type=default"})
public class Log4jLogComponent implements Log {
	public Log4jLogComponent() {
		System.out.println("Log4jLogComponent created");
	}
	public void logMessage(String message) {
		System.out.println("LOG log4j: " + message);
	}
}
