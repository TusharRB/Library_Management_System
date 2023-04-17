package com.example.Library_management_system.Convertor;

import com.example.Library_management_system.DTO.RequestDto.StudentRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.AllStudentResponseDto;
import com.example.Library_management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_management_system.entity.Student;
import lombok.experimental.UtilityClass;
/*
@UtilityClass
public class StudentConvertor {
    public static Student studentRequestDtoToStudent(StudentRequestDto studentRequestDto)
    {
        return Student.builder()
                .studentName(studentRequestDto.getName())
                .studentAge(studentRequestDto.getAge())
                .studentEmail(studentRequestDto.getMobNo())
                .department(studentRequestDto.getDepartment())
                .build();
    }
    public static AllStudentResponseDto studentToStudentResponseDto(Student student)
    {
        return StudentResponseDto.builder()
                .StudentName(student.name())
                .StudentEmail(student.mobNo())
                .Age(student.age())
                //.Department(student.getDepartment())
                .build();
    }
}
*/