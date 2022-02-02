package org.example.osgi.logging.console;

import org.example.osgi.logging.Log;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

@Component(property = {"type=log4j", "logfile=/tmp/log.txt"})
@ServiceRanking(100)
public class Log4jLogComponent implements Log {
	public Log4jLogComponent() {
		System.out.println("Log4jLogComponent created");
	}
	public void logMessage(String message) {
		System.out.println("LOG log4j: " + message);
	}
}
