package com.dd.glearning.emp.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is dto class which is responsible to carry employee related data from Rest Controller to data repository and
 * vice versa.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 11-04-2023
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetails {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
}