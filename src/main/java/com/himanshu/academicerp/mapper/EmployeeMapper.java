package com.himanshu.academicerp.mapper;

import com.himanshu.academicerp.dto.EmployeeRequest;
import com.himanshu.academicerp.entity.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest employeeRequest, String photographPath) {
        return Employee.builder()
                .firstName(employeeRequest.firstName())
                .lastName(employeeRequest.lastName())
                .email(employeeRequest.email())
                .photographPath(photographPath)
                .department(employeeRequest.department())
                .build();
    }
}
