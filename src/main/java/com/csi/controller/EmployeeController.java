package com.csi.controller;

import com.csi.constant.EndPointConstant;
import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping(EndPointConstant.SIGN_UP)
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee){

        return ResponseEntity.ok(employeeServiceImpl.signUp(employee));
    }

    @GetMapping(EndPointConstant.SIGN_IN)
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword){

        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));
    }

    @GetMapping(EndPointConstant.GET_DATA_BY_ID)
    public ResponseEntity<Employee> getDataById(@PathVariable long empId){

        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpId(empId).orElseThrow(()-> new RecordNotFoundException("Employee ID Does Not Exist")));
    }

    @GetMapping(EndPointConstant.GET_ALL_DATA)
    public ResponseEntity<List<Employee>> getAllData(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @GetMapping(EndPointConstant.GET_DATA_BY_NAME)
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empFirstName){

        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpFirstName(empFirstName));
    }

    @GetMapping(EndPointConstant.GET_DATA_BY_CONTACT_NUMBER)
    public ResponseEntity<Employee> getDataByContactNumber(@PathVariable long empContactNumber){

        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpContactNumber(empContactNumber));
    }

    @GetMapping(EndPointConstant.GET_DATA_BY_EMAIL_Id)
    public ResponseEntity<Employee> getDataByEmailId(@PathVariable String empEmailId){

        return ResponseEntity.ok(employeeServiceImpl.getDataByEmpEmailId(empEmailId));
    }

    @GetMapping(EndPointConstant.GET_DATA_BY_FIRST_NAME_AND_LAST_NAME)
    public ResponseEntity<List<Employee>> getDataByFirstNameAndLastName(@PathVariable String empFirstName, @PathVariable String empLastName){

        return ResponseEntity.ok(employeeServiceImpl.getDatabByEmpFirstNameAndEmpLastName(empFirstName,empLastName));
    }

    @GetMapping(EndPointConstant.GET_DATA_BY_ANY_INPUT)
    public ResponseEntity<List<Employee>> getDataByAnyInput(@PathVariable String input){

        List<Employee> employeeList = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        for(Employee employee : employeeServiceImpl.getAllData()){

            String dob = dateFormat.format(employee.getEmpDOB());

            if(employee.getEmpFirstName().equals(input)
            || employee.getEmpLastName().equals(input)
            || employee.getEmpAddress().equals(input)
            || String.valueOf(employee.getEmpContactNumber()).equals(input)
            || String.valueOf(employee.getEmpSalary()).equals(input)
            || String.valueOf(employee.getEmpAge()).equals(input)
            || employee.getEmpEmailId().equals(input)
            || dob.equals(input)){

                employeeList.add(employee);
            }
        }

        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(EndPointConstant.GET_DATA_BY_DOB)
    public ResponseEntity<List<Employee>> getDataByDOB(@PathVariable String empDOB){

        List<Employee> employeeList = new ArrayList<>();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        for(Employee employee : employeeServiceImpl.getAllData()){

            String dob = dateFormat.format(employee.getEmpDOB());

            if(dob.equals(empDOB)){

                employeeList.add(employee);
            }
        }
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(EndPointConstant.SORT_BY_AGE)
    public ResponseEntity<List<Employee>> sortByAge(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingLong(Employee::getEmpAge)).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstant.SORT_BY_SALARY)
    public ResponseEntity<List<Employee>> sortBySalary(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparingDouble(Employee::getEmpSalary)).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstant.SORT_BY_NAME)
    public ResponseEntity<List<Employee>> sortByName(){

        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().sorted(Comparator.comparing(Employee::getEmpFirstName)).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstant.FILTER_BY_SALARY)
    public ResponseEntity<List<Employee>> filterBySalary(@PathVariable double empSalary){

        return ResponseEntity.ok(employeeServiceImpl.getAllData().stream().filter(emp-> emp.getEmpSalary()>=empSalary).collect(Collectors.toList()));
    }

    @GetMapping(EndPointConstant.CHECK_LOAN_ELIGIBILITY)
    public ResponseEntity<String> checkLoanEligibility(@PathVariable long empId){

        String message = null;
       for(Employee employee : employeeServiceImpl.getAllData()){
           if(employee.getEmpId()==empId && employee.getEmpSalary()>=50000.0){
               message="Yes!! Eligible for loan";
               break;
           }else {
               message="Oops ,No! Not eligible for loan";
           }
       }
       return ResponseEntity.ok(message);
    }

    @PostMapping(EndPointConstant.SAVE_BULK_OF_DATA)
    public ResponseEntity<List<Employee>> saveBulkOfData(@RequestBody List<Employee> employees){

        return ResponseEntity.ok(employeeServiceImpl.saveBulkOfData(employees));
    }

    @PutMapping(EndPointConstant.UPDATE_DATA)
    public ResponseEntity<Employee> updateDataById( @RequestBody Employee employee,@PathVariable long empId){

        Employee employee1 = employeeServiceImpl.getDataByEmpId(empId).orElseThrow(()-> new RecordNotFoundException("Employee ##ID not exist"));

        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpLastName(employee.getEmpLastName());
        employee1.setEmpFirstName(employee.getEmpFirstName());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpPassword(employee.getEmpPassword());
        employee1.setEmpAge(employee.getEmpAge());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpEmailId(employee.getEmpEmailId());

        return new ResponseEntity<>(employeeServiceImpl.updateData(employee1), HttpStatus.CREATED);
    }

    @DeleteMapping(EndPointConstant.DELETE_BY_ID)
    public ResponseEntity<String> deleteBYId(@PathVariable long empId){

        employeeServiceImpl.deleteByEmpId(empId);

        return ResponseEntity.ok("Data Deleted Successfully");
    }

    @DeleteMapping(EndPointConstant.DELETE_ALL)
    public ResponseEntity<String> deleteAll(){

        employeeServiceImpl.deleteAll();

        return ResponseEntity.ok("Data Deleted Successfully");
    }


}
