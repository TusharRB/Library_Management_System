package com.example.Library_management_system.controller;

import com.example.Library_management_system.DTO.RequestDto.StudentRequestDto;
import com.example.Library_management_system.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.AllStudentResponseDto;
import com.example.Library_management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_management_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_management_system.entity.Student;
import com.example.Library_management_system.exceptions.StudentNotFoundException;
import com.example.Library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);
    }

    @PutMapping("/update_mobile")
    public UpdateStudentMobNoResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        return studentService.updateMobNo(updateStudentMobRequestDto);
    }

    @DeleteMapping("/delete_by_id")
    public String deleteById(@RequestParam("id") int id){
        return studentService.deleteById(id);
    }

    @GetMapping("/get_student_by_id")
    public StudentResponseDto getStudentById(@RequestParam("id") int id){

        return studentService.getStudentById(id);
    }

    @GetMapping("/find_all_student")
    public List<AllStudentResponseDto> findAllStudent(){
        return studentService.findAllStudent();
    }


    // delete a student by id

    // update the student by id

    // find a student by id

    // find all the students
}
