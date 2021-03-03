package com.company.repositories.interfaces;

import com.company.entities.Employee;

import java.util.List;

public interface IEmployeeRepositories {
    boolean addEmployee(Employee employee);
    List<Employee> getEmployeesByJob(String job);
    Employee deleteEmployeeByName(String name);
    List<Employee> getAllEmployees();
}
