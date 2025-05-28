package com.carrier.carrierapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@SpringBootApplication
public class CarrierappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarrierappApplication.class, args);
	}

}
