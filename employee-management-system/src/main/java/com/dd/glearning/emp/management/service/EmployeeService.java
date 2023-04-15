package com.dd.glearning.emp.management.service;

import com.dd.glearning.emp.management.dto.EmployeeDetails;

import java.util.List;

/**
 * This is the interface which contains all contract of Employee management service. Implementation class of this
 * interface is {@link com.dd.glearning.emp.management.service.impl.EmployeeServiceImpl}
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 04-11-2023
 */
public interface EmployeeService {
    public List<EmployeeDetails> getAllEmployees();
    public void saveEmployee(EmployeeDetails employee);
    public	EmployeeDetails getEmployeeById(long id);
    public	void deleteEmployeeById(long  id);
}
