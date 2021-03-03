package com.company.controllers;

import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

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
}
