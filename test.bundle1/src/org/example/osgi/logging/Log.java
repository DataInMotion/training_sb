package org.example.osgi.logging;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Log {
	void logMessage(String message);
}