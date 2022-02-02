package org.example.osgi.logging.console;

import org.example.osgi.logging.Log;
import org.osgi.service.component.annotations.Component;

@Component(property = {"type=default"})
public class ConsoleLogComponent implements Log {
	public ConsoleLogComponent() {
		System.out.println("ConsoleLogComponent created");
	}
	public void logMessage(String message) {
		System.out.println("LOG: " + message);
	}
}
