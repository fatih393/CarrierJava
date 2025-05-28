package com.carrier.carrierapp;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class SwaggerLauncher {

	@EventListener(ApplicationReadyEvent.class)
	public void openSwaggerUi() {
		try {
			URI uri = new URI("http://localhost:8080/swagger-ui/index.html");
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().browse(uri);
			} else {
				System.out.println("Desktop is not supported. Open Swagger UI manually: " + uri.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
