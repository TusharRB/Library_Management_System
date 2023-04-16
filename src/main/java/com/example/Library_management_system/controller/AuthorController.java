package com.example.Library_management_system.controller;

import com.example.Library_management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_system.entity.Author;
import com.example.Library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController // tell spring this is a class where write api end point
@RequestMapping("/author") // mapped all the function in this class by author end point

public class AuthorController {

    @Autowired
    AuthorService authorService;
    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){

        return authorService.addAuthor(author);

    }

    @GetMapping("/get_by_email")
    public AuthorResponseDto getAuthorByEmail(@RequestParam("email") String email){

        return authorService.getAuthorByEmail(email);
    }
    // delete a student by id

    // update the student by id

    // find a student by id

    // find all the students
}
