package com.glo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		// Initialize Spring Context
		ApplicationContext classPathContext = new ClassPathXmlApplicationContext("spring-config.xml");

		// Create Fleet object
		Fleet fleetFromClassPath = classPathContext.getBean("fleet", Fleet.class);
		System.out.println("Fleet Details from ClassPathXmlApplicationContext:");
        printFleetDetails(fleetFromClassPath);

     // Using FileSystemXmlApplicationContext
        ApplicationContext fileSystemContext = new FileSystemXmlApplicationContext("src/main/resources/spring-config.xml");
        
     // Create Fleet object using FileSystemXmlApplicationContext
        Fleet fleetFromFileSystem = fileSystemContext.getBean("fleet", Fleet.class);
        System.out.println("Fleet Details from FileSystemXmlApplicationContext:");
        printFleetDetails(fleetFromFileSystem);
        
		/*
		 * // Use fleet object as needed System.out.println("Fleet Details:");
		 * System.out.println("ID: " + fleet.getFleetId());
		 * System.out.println("Origin: " + fleet.getOrigin());
		 * System.out.println("Destination: " + fleet.getDestination());
		 * System.out.println("Required Fleets: " + fleet.getRequiredFleets());
		 */
	}
	
	private static void printFleetDetails(Fleet fleet) {
        System.out.println("ID: " + fleet.getFleetId());
        System.out.println("Origin: " + fleet.getOrigin());
        System.out.println("Destination: " + fleet.getDestination());
        System.out.println("Required Fleets: " + fleet.getRequiredFleets());
    }
}
