package com.example.Library_management_system.controller;

import com.example.Library_management_system.DTO.RequestDto.AuthorRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_system.entity.Author;
import com.example.Library_management_system.service.AuthorService;
import jakarta.validation.GroupSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @GetMapping("/get_author_by_id")
    public AuthorResponseDto getAuthorById(@RequestParam("id") int id) throws Exception {

        return authorService.getAuthorById(id);
    }


    @GetMapping("/get_all_author")
    public List<AuthorResponseDto> getAllAuthor(){

        return authorService.getAllAuthor();

    }

    @PutMapping("/update_author_by_id")
    public AuthorResponseDto updateAuthorById(@RequestBody AuthorRequestDto authorRequestDto) throws Exception {

        return authorService.updateAuthorById(authorRequestDto);
    }

    @DeleteMapping("/delete_author_by_id")
    public String deleteAuthorById(@RequestParam("id") int id) {

        return authorService.deleteAuthorById(id);
    }

    // delete a Author by id

    // update the Author by id

    // find a Author by id

    // find all the Authors
}
