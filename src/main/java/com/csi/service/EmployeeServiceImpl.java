package com.csi.service;

import com.csi.dao.EmployeeDaoImpl;
import com.csi.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EmployeeServiceImpl {

    @Autowired
    EmployeeDaoImpl employeeDaoImpl;

    public Employee signUp(Employee employee){

        return employeeDaoImpl.signUp(employee);
    }

    public boolean signIn(String empEmailId, String empPassword){

        return employeeDaoImpl.signIn(empEmailId,empPassword);
    }

    public Optional<Employee> getDataByEmpId(long empId){

        return employeeDaoImpl.getDataByEmpId(empId);
    }

    public List<Employee> getAllData(){

        return employeeDaoImpl.getAllData();
    }

    public List<Employee> getDataByEmpFirstName(String empFirstName){

        return employeeDaoImpl.getDataByEmpFirstName(empFirstName);
    }

    public Employee getDataByEmpContactNumber(long empContactNumber){

        return employeeDaoImpl.getDataByEmpContactNumber(empContactNumber);
    }

    public Employee getDataByEmpEmailId(String empEmailId){

        return employeeDaoImpl.getDataByEmpEmailId(empEmailId);
    }

    public List<Employee> getDatabByEmpFirstNameAndEmpLastName(String empFirstName, String empLastName){

        return employeeDaoImpl.getDatabByEmpFirstNameAndEmpLastName(empFirstName,empLastName);
    }

    public List<Employee> saveBulkOfData(List<Employee> employees){

        return employeeDaoImpl.saveBulkOfData(employees);
    }

    public Employee updateData(Employee employee){

        return employeeDaoImpl.updateData(employee);
    }

    public void deleteByEmpId(long empId){

        employeeDaoImpl.deleteByEmpId(empId);
    }

    public void deleteAll(){

        employeeDaoImpl.deleteAll();
    }

}
