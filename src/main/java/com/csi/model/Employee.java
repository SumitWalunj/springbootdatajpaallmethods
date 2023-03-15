package com.csi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.util.FuzzyBoolean;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue
    private long empId;

    @Size(min = 2, message = "Employee FirstName should be atleast 2 character")
    private String empFirstName;

    @NotNull
    private String empLastName;

    @NotNull
    private String empAddress;

    @NotNull
    private double empSalary;

    @Range(min = 1000000000, max = 9999999999L , message = "Employee Contact Number should be 10 digit")
    private long empContactNumber;

    @NotNull
    private int empAge;

    @JsonFormat(pattern = "dd-MM-yyyy")
    @NotNull
    private Date empDOB;

    @Email(message = "Email should be Valid")
    private String empEmailId;

    @Size(min = 4, message = "Password should be atleast 4 character")
    private String empPassword;

}
