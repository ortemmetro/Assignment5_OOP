package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.interfaces.IEmployeeRepositories;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class EmployeeRepositories implements IEmployeeRepositories{
    private final IDB db;

    public EmployeeRepositories(IDB db){
        this.db = db;
    }

    @Override
    public boolean addEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO employees(name, surname, job, salary, address) VALUES(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(
                    "INSERT INTO employees(name, surname, job, salary, address) VALUES(?,?,?,?,?)");

            st.setString(1, employee.getName());
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getJob());
            st.setDouble(4, employee.getSalary());
            st.setString(5, employee.getAddress());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public List<Employee> getEmployeesByJob(String job) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, job, salary, address FROM employees WHERE job = ?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, job);


            ResultSet resset = st.executeQuery();
            List<Employee> employees = new LinkedList<>();
            while (resset.next()) {
                Employee employee = new Employee(
                        resset.getInt("ID"),
                        resset.getString("name"),
                        resset.getString("surname"),
                        resset.getString("job"),
                        resset.getDouble("salary"),
                        resset.getString("address"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Employee deleteEmployeeByName(String name) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM employees WHERE name=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, name);

            ResultSet resset = st.executeQuery();
            if (resset.next()) {
                Employee employee = new Employee(
                        resset.getInt("id"),
                        resset.getString("name"),
                        resset.getString("surname"),
                        resset.getString("job"),
                        resset.getDouble("salary"),
                        resset.getString("address"));
                return employee;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id, name, surname, job, salary, address FROM employees";
            Statement st = con.createStatement();

            ResultSet resset = st.executeQuery(sql);
            List<Employee> employees = new LinkedList<>();
            while(resset.next()){
                Employee employee = new Employee(
                        resset.getInt("id"),
                        resset.getString("name"),
                        resset.getString("surname"),
                        resset.getString("job"),
                        resset.getDouble("salary"),
                        resset.getString("address"));
                employees.add(employee);
            }
            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
}
