package com.example.Library_management_system.service.impl;

import com.example.Library_management_system.DTO.RequestDto.StudentRequestDto;
import com.example.Library_management_system.DTO.RequestDto.UpdateStudentMobRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.AllStudentResponseDto;
import com.example.Library_management_system.DTO.ResponseDto.StudentResponseDto;
import com.example.Library_management_system.DTO.ResponseDto.UpdateStudentMobNoResponseDto;
import com.example.Library_management_system.entity.Card;
import com.example.Library_management_system.entity.Student;
import com.example.Library_management_system.enums.CardStatus;
import com.example.Library_management_system.exceptions.StudentNotFoundException;
import com.example.Library_management_system.repository.StudentRepository;
import com.example.Library_management_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto){

        Student student = new Student();
        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setMobNo(studentRequestDto.getMobNo());
        student.setDepartment(studentRequestDto.getDepartment());



        // generate a new card for the student
        Card card = new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-01-01");
        card.setStudent(student);

        // set card for the student
        student.setCard(card);
        studentRepository.save(student);
        return "Student added";

    }

    @Override
    public UpdateStudentMobNoResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {

        try{
             Student student = studentRepository.findById(updateStudentMobRequestDto.getId()).get();

             student.setMobNo(updateStudentMobRequestDto.getMobNo());
             Student updatedStudent = studentRepository.save(student);


             // prepare Response dto

            UpdateStudentMobNoResponseDto updateStudentMobNoResponseDto = new UpdateStudentMobNoResponseDto();


            updateStudentMobNoResponseDto.setName(updatedStudent.getName());
            updateStudentMobNoResponseDto.setMobNo(updateStudentMobRequestDto.getMobNo());

            return updateStudentMobNoResponseDto;

        }
        catch (Exception e){
            throw new StudentNotFoundException("Invalid Student Id");
        }
    }

    @Override
    public StudentResponseDto getStudentById(int id) {

        Student student = studentRepository.findById(id).get();

        // Prepare Response Dto

        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setMobNo(student.getMobNo());

        return  studentResponseDto;
    }

    @Override
    public List<AllStudentResponseDto> findAllStudent() {


        List<Student> studentList = studentRepository.findAll();
       List<AllStudentResponseDto> students = new ArrayList<>();



        for(Student student : studentList){


            AllStudentResponseDto allStudentResponseDto = new AllStudentResponseDto();
            allStudentResponseDto.setId(student.getId());
            allStudentResponseDto.setName(student.getName());
            allStudentResponseDto.setAge(student.getAge());
            allStudentResponseDto.setDepartment(student.getDepartment());
            allStudentResponseDto.setMobNo(student.getMobNo());
            students.add(allStudentResponseDto);
        }

        return students;



    }

    @Override
    public String deleteById(int id) {

        //studentRepository.deleteById(id);

        Student student = studentRepository.findById(id).get();

        if(student != null){

            studentRepository.deleteById(id);
            return "Student Deleted Successfully";
        }

        return "Student not found";

    }
}
