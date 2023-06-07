package com.example.Library_management_system.service.impl;

import com.example.Library_management_system.DTO.RequestDto.AuthorRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.AuthorResponseDto;
import com.example.Library_management_system.entity.Author;
import com.example.Library_management_system.repository.AuthorRepository;
import com.example.Library_management_system.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public AuthorResponseDto getAuthorById(int id) throws Exception {

        try{

            Author author = authorRepository.findById(id).get();

            // prepare Response Dto

            AuthorResponseDto authorResponseDto = new AuthorResponseDto();

            authorResponseDto.setName(author.getName());
            authorResponseDto.setAge(author.getAge());

            return authorResponseDto;
        }
        catch (Exception e){
            throw new Exception("Author Not Present");
        }


    }

    @Override
    public List<AuthorResponseDto> getAllAuthor() {

        List<Author> authorList = authorRepository.findAll();

        List<AuthorResponseDto> authors = new ArrayList<>();

        for(Author author : authorList){

            AuthorResponseDto authorResponseDto = new AuthorResponseDto();

            authorResponseDto.setAge(author.getAge());
            authorResponseDto.setName(author.getName());

            authors.add(authorResponseDto);
        }

        return authors;

    }

    @Override
    public AuthorResponseDto updateAuthorById(AuthorRequestDto authorRequestDto) throws Exception {

        try{

            Author author = authorRepository.findById(authorRequestDto.getId()).get();

            author.setName(authorRequestDto.getName());
            author.setAge(authorRequestDto.getAge());
            author.setEmail(authorRequestDto.getEmail());

            authorRepository.save(author);

            // Prepare Response Dto

            AuthorResponseDto authorResponseDto = new AuthorResponseDto();

            authorResponseDto.setName(author.getName());
            authorResponseDto.setAge(author.getAge());


            return authorResponseDto;
        }
        catch (Exception e){

            throw new Exception("Invalid Id");
        }
    }

    @Override
    public String deleteAuthorById(int id) {

            Author author = authorRepository.findById(id).get();

            if(author != null) {

                authorRepository.deleteById(id);

                return "Author Deleted Successfully";
            }

            return  "Invalid Author Id";

    }


}
