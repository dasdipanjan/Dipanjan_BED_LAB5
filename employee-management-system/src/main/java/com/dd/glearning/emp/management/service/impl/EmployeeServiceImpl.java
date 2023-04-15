package com.dd.glearning.emp.management.service.impl;

import com.dd.glearning.emp.management.dto.EmployeeDetails;
import com.dd.glearning.emp.management.model.Employee;
import com.dd.glearning.emp.management.repository.EmployeeCrudRepository;
import com.dd.glearning.emp.management.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * This class is the implementation class of {@link EmployeeService} interface.
 * It has all method implementation of {@link EmployeeService} interface's method.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 04-11-2023
 */
@Service
@Slf4j
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeCrudRepository employeeCrudRepository;

    public EmployeeServiceImpl(EmployeeCrudRepository employeeCrudRepository) {
        super();
        this.employeeCrudRepository = employeeCrudRepository;
    }

    /**
     * This method is responsible to return all Employees details in form of list.
     *
     * @return Object of {@link Employee} {@link List}
     */
    @Override
    public List<EmployeeDetails> getAllEmployees() {
        List<Employee> employees = employeeCrudRepository.findAll();
        List<EmployeeDetails> employeeDetailsList = new ArrayList<>();
        if (!employees.isEmpty()) {
            employees.forEach(employee -> {
                EmployeeDetails employeeDetails = new EmployeeDetails();
                BeanUtils.copyProperties(employee, employeeDetails);
                employeeDetailsList.add(employeeDetails);
            });
            log.info("Employee details list has been prepared.");
        }
        return employeeDetailsList;
    }

    /**
     * This method is responsible to create new employee records in database. If employee already exists in the
     * database then it will update different field of employee records.
     *
     * @param employeeDetails {@link EmployeeDetails} object.
     */
    @Override
    public void saveEmployee(EmployeeDetails employeeDetails) {
        Optional<Employee> optional = employeeCrudRepository.findById(employeeDetails.getId());
        if (optional.isPresent()) {
            BeanUtils.copyProperties(employeeDetails, optional.get());
            Employee updatedEmployee = employeeCrudRepository.saveAndFlush(optional.get());
            log.info("Updated Employee Details := {}", updatedEmployee);
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDetails, employee);
            Employee persistedEmployee = employeeCrudRepository.saveAndFlush(employee);
            log.info("Newly Persisted Employee Details := {}", persistedEmployee);
        }

    }

    /**
     * This method is responsible to retrieve employee information by its id information.
     *
     * @param id employee id.
     * @return Object of {@link EmployeeDetails}
     */
    @Override
    public EmployeeDetails getEmployeeById(long id) {
        EmployeeDetails employeeDetails = new EmployeeDetails();
        Optional<Employee> optional = employeeCrudRepository.findById(id);
        optional.ifPresent(employee -> BeanUtils.copyProperties(employee, employeeDetails));
        return employeeDetails;
    }

    /**
     * This method is responsible to delete a particular employee by its id.
     *
     * @param id Employee Id.
     */
    @Override
    public void deleteEmployeeById(long id) {
        employeeCrudRepository.deleteById(id);
    }
}
