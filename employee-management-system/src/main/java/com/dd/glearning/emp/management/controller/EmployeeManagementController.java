package com.dd.glearning.emp.management.controller;

import com.dd.glearning.emp.management.dto.EmployeeDetails;
import com.dd.glearning.emp.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * This is dto class which is responsible to carry employee related data from Rest Controller to data repository and
 * vice versa.
 *
 * @author Dipanjan Das
 * @version 1.0
 * @since 11-04-2023
 */
@Controller
@RequestMapping("/employees")
public class EmployeeManagementController {
    private EmployeeService employeeService;

    /**
     * Constructor of {@link EmployeeManagementController} class.
     *
     * @param employeeService Instance of {@link EmployeeService} interface.
     */
    @Autowired
    public EmployeeManagementController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    /**
     * This method is responsible to redirect to employee list page when user will request for employee list page.
     *
     * @param model Object of {@link Model} class.
     * @return the name of HTML page.
     */
    @GetMapping("/list")
    public String showEmpList(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees-list";
    }

    /**
     * This method is responsible to accept create employee request and display the create employee page.
     *
     * @param model Object of {@link Model} class.
     * @return the page name of create-employee.
     */
    @GetMapping("/create-emp")
    public String createEmp(Model model) {
        model.addAttribute("employeeDetails", new EmployeeDetails());
        return "create-employee";
    }

    /**
     * This method is responsible to accept save Employee details request and return the employee list page.
     *
     * @param model Object of {@link Model}
     * @param employeeDetails Object of {@link EmployeeDetails}
     * @return the name of employee list page.
     */
    @PostMapping("/saveEmp")
    public String saveEmp(Model model, @ModelAttribute("employeeDetails") EmployeeDetails employeeDetails) {
        employeeService.saveEmployee(employeeDetails);
        return "redirect:/employees/list";
    }

    /**
     * This method is responsible to accept employee delete request by id. After employee details deletion it redirects
     * to employee list page.
     *
     * @param model Object of Model class.
     * @param id Employee Id.
     * @return Employee List page.
     */
    @GetMapping("/delete/{id}")
    public String deleteEmp(Model model, @PathVariable int id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employees/list";
    }

    /**
     * This method is responsible to update employee information in database.
     *
     * @param model Object of {@link Model} class.
     * @param id Employee Id.
     * @return update employee screen.
     */
    @GetMapping("/update/{id}")
    public String updateEmp(Model model, @PathVariable int id) {
        EmployeeDetails employeeDetails = employeeService.getEmployeeById(id);
        model.addAttribute("employeeDetails", employeeDetails);
        return "update-employee";
    }
}
