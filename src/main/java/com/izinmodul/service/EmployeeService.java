package com.izinmodul.service;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.izinmodul.entities.EmployeeEntity;
import com.izinmodul.forms.Employee;
import com.izinmodul.repositories.EmployeeRepository;
import com.izinmodul.ui.EmployeeResponse;

@Service
public class EmployeeService {

    public static final Logger log = Logger.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional(readOnly = true)
    public Employee getEmployee(int employeeId) {

        log.info("Received request to return employee with id: " + employeeId);
        try {
            EmployeeEntity employeeEntity = employeeRepository.findOne(employeeId);
            Employee employee = new Employee();

            employee.setEmployeeId(employeeEntity.getEmployeeId());
            employee.setEmployeeName(employeeEntity.getEmployeeName());
            employee.setEmployeeSurname(employeeEntity.getEmployeeSurname());
            employee.setEmployeeBalance(employeeEntity.getEmployeeBalance());

            log.info("Request for Employee with id: " + employeeId + " was successful");

            return employee;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }


    @Transactional(readOnly = true)
    public List<Employee> getEmployees() {

        log.info("Received request to return list of all employees");

        try {
            List<Employee> employeeList = new ArrayList<Employee>();
            List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
            for (EmployeeEntity employeeEntity : employeeEntityList) {
                Employee employee = new Employee();


                employee.setEmployeeId(employeeEntity.getEmployeeId());
                employee.setEmployeeName(employeeEntity.getEmployeeName());
                employee.setEmployeeSurname(employeeEntity.getEmployeeSurname());
                employee.setEmployeeBalance(employeeEntity.getEmployeeBalance());
                employeeList.add(employee);
            }
            log.info("A total of " + employeeList.size() + " employees were returned ");

            return employeeList;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }

    @Transactional(readOnly = true)
    public Employee getEmployeeDetails(String id) {

        log.info("Received request to return employee with id: " + id);
        try {
            EmployeeEntity employeeEntity = employeeRepository.findById(id);
            Employee employee = new Employee();

            employee.setEmployeeName(employeeEntity.getEmployeeName());
            employee.setEmployeeSurname(employeeEntity.getEmployeeSurname());
            employee.setEmployeeBalance(employeeEntity.getEmployeeBalance());

            log.info("Request for Employee details with id " + id + " was successful");

            return employee;
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }

    @Transactional
    public EmployeeResponse addEmployee(EmployeeEntity employee) {

        try {
            log.info("Adding " + employee.toString());
            double leaveBalance = calculateInitialLeaveDays(employee.getEmployeeName(), employee.getEmployeeSurname(), employee.getEmployeeWorkedYear());
            employee.setEmployeeBalance(leaveBalance);
            employeeRepository.save(employee);
            log.info(employee.getEmployeeName() + employee.getEmployeeSurname() + " added successfully");

        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

        return null;
    }

    @Transactional
    public void editEmployeeLeave(int employeeId, double leaveBalance) {

        try {

            log.info("Editing leave balance ");

            EmployeeEntity employeeEntity = employeeRepository.getOne(employeeId);

            employeeEntity.setEmployeeBalance(leaveBalance);



            employeeRepository.save(employeeEntity);
            log.info(employeeEntity.getEmployeeName() + employeeEntity.getEmployeeSurname() + " edited successfully");

      //      return new EmployeeResponse(employee.getEmployeeBalance(), employee.getUsername(), employee.getPassword());
        } catch (Exception e) {
            log.error("Exception thrown ", e);
        }

       // return null;
    }


    private double calculateInitialLeaveDays(String name, String surname, int employeeWorkedYear) {

        log.info("Calculating Leave for new employee " + name + " " + surname);

        int totalRemainingDay = 5;
        if (employeeWorkedYear > 1 && employeeWorkedYear <= 5) {
        	totalRemainingDay = 15;
        }
        else if (employeeWorkedYear > 5 && employeeWorkedYear <= 10) {
        	totalRemainingDay = 18;
        }
        else if (employeeWorkedYear > 10) {
        	totalRemainingDay = 24;
        } 

        log.info("A total of "+ totalRemainingDay + " days are allocated to " + name + " " + surname);

        return totalRemainingDay;

    }


}