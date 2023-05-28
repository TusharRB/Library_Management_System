package com.example.Library_management_system.service;

import com.example.Library_management_system.DTO.RequestDto.AuthorRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_system.entity.Author;

import java.util.List;


public interface AuthorService {

    public String addAuthor(Author author);

    public AuthorResponseDto getAuthorByEmail(String email);

    AuthorResponseDto getAuthorById(int id) throws Exception;

    List<AuthorResponseDto> getAllAuthor();

    AuthorResponseDto updateAuthorById(AuthorRequestDto authorRequestDto) throws Exception;

    String deleteAuthorById(int id);
}
