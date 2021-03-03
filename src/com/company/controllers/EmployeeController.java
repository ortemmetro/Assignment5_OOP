package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.util.List;

public class EmployeeController {
    private final IEmployeeRepositories repo;

    public EmployeeController(IEmployeeRepositories repo){
        this.repo = repo;
    }

    public String addEmployee(String name, String surname, String job, double salary, String address){
        Employee employee = new Employee(name, surname, job, salary, address);
        boolean added = repo.addEmployee(employee);
        return (added ? "Employee was added successfully!" : "Employee was not added :(");
    }

    public String getEmployeesByJob(String job){
        List<Employee> employees = repo.getEmployeesByJob(job);
        return (employees == null ? "There are no employees with such job :(" : employees.toString());
    }

    public String deleteEmployeeByName(String name){
        Employee employee = repo.deleteEmployeeByName(name);
        return (employee == null ? "Employee was not found!" :
                "Deleting was completed successfully!");
    }

    public String getAllEmployees(){
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
}
