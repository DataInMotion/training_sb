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
package org.example.osgi.hello.command;

import java.io.IOException;
import java.util.Collections;
import java.util.Hashtable;
import java.util.UUID;

import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * 
 * @author Juergen Albert
 * @since 2 Feb 2022
 */
@Component(	service = Object.class)
@Command(scope = "hello", function = {"sayHello", "config"})
public class HelloCommand {
	public void sayHello() {
		System.out.println("Hello");
	}

	@Reference
	ConfigurationAdmin ca;
	
	public void config(String key, String value) {
		try {
			Configuration configuration = ca.getFactoryConfiguration("testconfig", UUID.randomUUID().toString());
			
			configuration.update(new Hashtable<String, String>(Collections.singletonMap(key, value)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

