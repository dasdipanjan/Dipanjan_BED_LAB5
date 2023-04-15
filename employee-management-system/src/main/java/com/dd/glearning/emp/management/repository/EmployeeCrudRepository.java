package com.dd.glearning.emp.management.repository;

import com.dd.glearning.emp.management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface is responsible to do crud operation for employee entity.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 04-11-2023
 */
@Repository
public interface EmployeeCrudRepository extends JpaRepository<Employee, Long> {

}
