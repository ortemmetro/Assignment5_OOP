package com.company;

import com.company.controllers.EmployeeController;
import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.repositories.EmployeeRepositories;
import com.company.repositories.interfaces.IEmployeeRepositories;

public class Main {

    public static void main(String[] args) {
        IDB db = new PostgresDB();
        IEmployeeRepositories repositories = new EmployeeRepositories(db);
        EmployeeController controller = new EmployeeController(repositories);
        Myapp myapp = new Myapp(controller);
        myapp.START();
    }
}
