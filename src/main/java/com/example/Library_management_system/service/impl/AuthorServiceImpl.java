package com.example.Library_management_system.service.impl;

import com.example.Library_management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_system.entity.Author;
import com.example.Library_management_system.repository.AuthorRepository;
import com.example.Library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author){

        authorRepository.save(author);

        return "Author Added Successfully";
    }

    @Override
    public AuthorResponseDto getAuthorByEmail(String email) {

        Author author = authorRepository.findByEmail(email);

        // prepare Response Dto

        AuthorResponseDto authorResponseDto = new AuthorResponseDto();

        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());

        return  authorResponseDto;

    }


}
