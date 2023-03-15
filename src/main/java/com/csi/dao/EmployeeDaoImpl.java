package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepositoryImpl;

    public Employee signUp(Employee employee) {

        return employeeRepositoryImpl.save(employee);
    }

    public boolean signIn(String empEmailId, String empPassword) {

        boolean flag = false;

      Employee employee=employeeRepositoryImpl.findDataByEmpEmailIdAndEmpPassword(empEmailId,empPassword);

        if (employee != null) {
            flag = true;
        }
        return flag;
    }

    public Optional<Employee> getDataByEmpId(long empId) {

        return employeeRepositoryImpl.findById(empId);
    }

    public List<Employee> getAllData() {

        return employeeRepositoryImpl.findAll();
    }

    public List<Employee> getDataByEmpFirstName(String empFirstName) {

        return employeeRepositoryImpl.getDataByEmpFirstName(empFirstName);
    }

    public Employee getDataByEmpContactNumber(long empContactNumber) {

        return employeeRepositoryImpl.getDataByEmpContactNumber(empContactNumber);
    }

    public Employee getDataByEmpEmailId(String empEmailId) {

        return employeeRepositoryImpl.getDataByEmpEmailId(empEmailId);
    }

    public List<Employee> getDatabByEmpFirstNameAndEmpLastName(String empFirstName, String empLastName) {

        return employeeRepositoryImpl.getDataByEmpFirstNameAndEmpLastName(empFirstName, empLastName);
    }

    public List<Employee> saveBulkOfData(List<Employee> employees) {

        return employeeRepositoryImpl.saveAll(employees);
    }

    public Employee updateData(Employee employee) {

        return employeeRepositoryImpl.save(employee);
    }

    public void deleteByEmpId(long empId) {

        employeeRepositoryImpl.deleteById(empId);
    }

    public void deleteAll() {

        employeeRepositoryImpl.deleteAll();
    }


}
