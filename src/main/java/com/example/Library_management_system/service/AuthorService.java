package com.example.Library_management_system.service;

import com.example.Library_management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_system.entity.Author;


public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorResponseDto getAuthorByEmail(String email);
}
