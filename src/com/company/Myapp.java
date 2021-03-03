package com.company;

import com.company.controllers.EmployeeController;

import java.util.Scanner;

public class Myapp {
    private final EmployeeController controller;
    private final Scanner scanner;

    public Myapp(EmployeeController controller){
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void START(){
        while(true){
            System.out.println();
            System.out.println("Welcome to the club, buddy! This is my application)");
            System.out.println("Select the letter: (1-5)");
            System.out.println("1)Add employee");
            System.out.println("2)Delete employee by name");
            System.out.println("3)Get employees by job");
            System.out.println("4)Get all employees");
            System.out.println("5)Exit");
            try{
                System.out.println("Enter the letter: (1-5)");
                int number = scanner.nextInt();
                if(number == 1){
                    addEmployee();
                }
                if(number == 2){
                    deleteEmployeeByName();
                }
                if(number == 3){
                    getEmployeesByJob();
                }
                if(number == 4){
                    getAllEmployees();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addEmployee(){
        System.out.println("Please enter name of employee:");
        String name = scanner.next();
        System.out.println("Please enter surname of employee:");
        String surname = scanner.next();
        System.out.println("Enter job of employee:");
        String job = scanner.next();
        System.out.println("Enter salary of employee:");
        double salary = scanner.nextDouble();
        System.out.println("Enter address of employee:");
        String address = scanner.next();
        String info = controller.addEmployee(name, surname, job, salary, address);
        System.out.println(info);
    }

    public void getEmployeesByJob(){
        System.out.println("Please enter job of employees:");
        String job = scanner.next();
        String info = controller.getEmployeesByJob(job);
        System.out.println(info);
    }

    public void deleteEmployeeByName(){
        System.out.println("Please enter a name of employee:");
        String name = scanner.next();
        System.out.println(controller.deleteEmployeeByName(name));
    }

    public void getAllEmployees(){
        String info = controller.getAllEmployees();
        System.out.println(info);
    }
}
