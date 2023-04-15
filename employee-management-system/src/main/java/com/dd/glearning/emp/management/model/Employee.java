package com.dd.glearning.emp.management.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

/**
 * This is the employee entity class. It holds different property of employee entity.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 11-04-2023
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee_tbl")
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_id_generator")
    @SequenceGenerator(
            name = "employee_id_generator",
            sequenceName = "employee_id_sequence",
            allocationSize = 1
    )
    @Column(name = "emp_id", nullable = false)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email_id", nullable = false)
    private String email;
}
