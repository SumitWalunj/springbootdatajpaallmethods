package com.csi.repository;

import com.csi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> getDataByEmpFirstName(String empFirstName);

    public Employee getDataByEmpContactNumber(long empContactNumber);

    public List<Employee> getDataByEmpFirstNameAndEmpLastName(String empFirstName, String empLastName);

    public Employee getDataByEmpEmailId(String empEmailId);

    public Employee findDataByEmpEmailIdAndEmpPassword(String empEmailId, String empPassword);
}
