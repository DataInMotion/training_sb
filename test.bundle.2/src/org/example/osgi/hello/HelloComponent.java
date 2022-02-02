/**
 * Copyright (c) 2012 - 2022 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v2.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v20.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.example.osgi.hello;

import org.example.osgi.logging.Log;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

/**
 * 
 * @author Juergen Albert
 * @since 2 Feb 2022
 */
@Component
public class HelloComponent {

//	@Reference(target = "(type=log4j)")
	private Log log;
	
	/**
	 * Creates a new instance.
	 */
	@Activate
	public HelloComponent(@Reference Log log) {
		this.log = log;
		System.out.println("Creating Hello World");
	}
	
//	@Activate
//	public void activate() {
//		System.out.println("Activate");
//		if(log != null) {
//			log.logMessage("Activated");
//		}
//	}

	@Deactivate
	public void deactivate() {
		if(log != null) {
			log.logMessage("Deactivated");
		}
	}
	
	@Reference(cardinality = ReferenceCardinality.OPTIONAL, policy = ReferencePolicy.DYNAMIC, target = "(type=log4j)")
	public void setLog(Log log) {
		this.log = log;
		log.logMessage("Here I Am");
	}

	public void unsetLog(Log log) {
		log.logMessage("Here I Go");
		this.log = null; 
	}
	
	
	
	
}
