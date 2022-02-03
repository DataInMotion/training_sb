/**
 * Copyright (c) 2012 - 2021 Data In Motion and others.
 * All rights reserved. 
 * 
 * This program and the accompanying materials are made available under the terms of the 
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Data In Motion - initial API and implementation
 */
package org.example.osgi.test;

import static org.assertj.core.api.Assertions.assertThat;

import org.example.osgi.logging.Log;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.osgi.framework.BundleContext;
import org.osgi.test.common.annotation.InjectBundleContext;
import org.osgi.test.common.annotation.InjectService;
import org.osgi.test.junit5.context.BundleContextExtension;
import org.osgi.test.junit5.service.ServiceExtension;

/**
 * This is your example OSGi integration test class
 * @since 1.0
 */
@ExtendWith(BundleContextExtension.class)
@ExtendWith(ServiceExtension.class)
public class ExampleIntegrationTest {
	
	public interface MyTest {
		int getTest();
	}
	
	/**
	 * Setup the services and maybe mock the services.
	 * The registered services are unregistered after the test
	 * @param bc the {@link BundleContext} that closes after each test
	 */
	@BeforeEach
	private void setupServices(@InjectBundleContext BundleContext bc) {
		
	}
	
	@Test
	public void testEventAdminExists(@InjectService Log log) {
		assertThat(log).isNotNull();
		
		log.logMessage("test");
	}

	@Test
	public void testNewLogServiceMethodLog4J(@InjectService(filter = "(type=log4j)") Log log) {
		assertThat(log).isNotNull();
		
		String result = log.toUpper("test");
		assertThat(result).isEqualTo("test".toUpperCase());
		
	}

	@Test
	public void testNewLogServiceMethodDefault(@InjectService(filter = "(type=default)") Log log) {
		assertThat(log).isNotNull();
		
		String result = log.toUpper("test");
		assertThat(result).isEqualTo("test".toUpperCase());
		
	}
	
}
