package com.example.Library_management_system.service;

import com.example.Library_management_system.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.IssueBookResponseDto;

public interface TransactionService {

    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception;
}
