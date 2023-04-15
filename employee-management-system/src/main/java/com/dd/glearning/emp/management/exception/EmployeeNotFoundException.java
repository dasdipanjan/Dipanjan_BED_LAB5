package com.dd.glearning.emp.management.exception;

/**
 * This is a custom exception class which is responsible to process exception when searched employee not found.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 11-04-2023
 */
public class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException() {

    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }

    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
