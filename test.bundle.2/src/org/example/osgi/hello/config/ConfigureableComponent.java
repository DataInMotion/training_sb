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
package org.example.osgi.hello.config;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;

/**
 * 
 * @author ungei
 * @since 2 Feb 2022
 */
@Component(name="testconfig", property = "test=true", configurationPolicy = ConfigurationPolicy.REQUIRE)
public class ConfigureableComponent {

	
	@Activate
	@Modified
	public void activate(Map<String, String> props) {
		System.out.println(this.toString() + " Config: " + props);
	}

	
}
