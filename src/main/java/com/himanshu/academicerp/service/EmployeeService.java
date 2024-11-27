package com.himanshu.academicerp.service;

import com.himanshu.academicerp.dto.EmployeeRequest;
import com.himanshu.academicerp.entity.Employee;
import com.himanshu.academicerp.mapper.EmployeeMapper;
import com.himanshu.academicerp.repository.EmployeeRepository;
import com.himanshu.academicerp.util.JwtUtil;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RequiredArgsConstructor
@Service
public class EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;
    private final JwtUtil jwtUtil;
    @Value("${image.directory}")
    private String imageDirectory;

    public String registerEmployee(EmployeeRequest request, String authHeader) throws IOException {
        if(!jwtUtil.validateAuthHeader(authHeader)){
            throw new BadRequestException("Invalid JWT token");
        }
        String email = request.email();
        if(employeeRepository.findByEmail(email).isPresent()){
            return "Already Exist";
        }
        String photographPath = saveImage(request.photograph());

        Employee employee = employeeMapper.toEntity(request, photographPath);
        employeeRepository.save(employee);
        return "Employee Saved";
    }

    private String saveImage(@NotNull(message = "Image is required") MultipartFile photograph) throws IOException {
        Path directory = Paths.get(imageDirectory);
        if(!Files.exists(directory)) {
            Files.createDirectories(directory);
        }

        String fileName = photograph.getOriginalFilename() + "-" + System.currentTimeMillis();
        Path filePath = directory.resolve(fileName);
        photograph.transferTo(filePath.toFile());

        return filePath.toString();
    }
}
