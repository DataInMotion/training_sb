package org.example.osgi.logging.console;

import org.example.osgi.logging.Log;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.propertytypes.ServiceRanking;

@Component(property = {"type=default"})
@ServiceRanking(1000)
public class ConsoleLogComponent implements Log {
	public ConsoleLogComponent() {
		System.out.println("ConsoleLogComponent created");
	}
	public void logMessage(String message) {
		System.out.println("LOG: " + message);
	}
	/* 
	 * (non-Javadoc)
	 * @see org.example.osgi.logging.Log#toUpper(java.lang.String)
	 */
	@Override
	public String toUpper(String text) {
		// TODO Auto-generated method stub
		return text.toUpperCase();
	}

}
