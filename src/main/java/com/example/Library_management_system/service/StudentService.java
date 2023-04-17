package com.example.Library_management_system.service;

import com.example.Library_management_system.DTO.RequestDto.StudentRequestDto;
import com.example.Library_management_system.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.AllStudentResponseDto;
import com.example.Library_management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_management_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_management_system.entity.Student;
import com.example.Library_management_system.exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {

    public String addStudent(StudentRequestDto studentRequestDto);

    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;

    public StudentResponseDto getStudentById(int id);

    public List<AllStudentResponseDto> findAllStudent();
    public String deleteById(int id);
}
