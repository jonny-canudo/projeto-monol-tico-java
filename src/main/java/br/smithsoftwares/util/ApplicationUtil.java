 package br.smithsoftwares.util;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Application;

public class ApplicationUtil extends Application {

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("jersey.config.server.provider.packages", "br.smithsoftwares.controllers");
		return properties;
	}
	
}
