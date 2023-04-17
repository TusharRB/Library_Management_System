package com.example.Library_management_system.DTO.ResponseDto;


import com.example.Library_management_system.enums.Department;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AllStudentResponseDto {

    private int id;

    private String name;
    private int age;
    private String mobNo;

    private Department department;
}
