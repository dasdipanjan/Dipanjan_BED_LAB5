package com.dd.glearning.emp.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * This class is the starter class of employee management system application.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 04-11-2023
 *
 */
@SpringBootApplication
public class EmployeeManagementSystemApplication {
	/**
	 * This method is the main entry point of the application. Spring Starter calls this method.
	 *
	 * @param args Command line arguments in form of Spring Array.
	 */
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementSystemApplication.class, args);
	}

}
