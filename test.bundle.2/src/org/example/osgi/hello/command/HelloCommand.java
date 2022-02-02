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

import org.osgi.service.component.annotations.Component;

/**
 * 
 * @author Juergen Albert
 * @since 2 Feb 2022
 */
@Component(	service = Object.class)
@Command(scope = "hello", function = "sayHello")
public class HelloCommand {
	public void sayHello() {
		System.out.println("Hello");
	}
}

