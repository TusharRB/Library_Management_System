package com.example.Library_management_system.service.impl;

import com.example.Library_management_system.DTO.RequestDto.IssueBookRequestDto;
import com.example.Library_management_system.DTO.ResponseDto.IssueBookResponseDto;
import com.example.Library_management_system.entity.Book;
import com.example.Library_management_system.entity.Card;
import com.example.Library_management_system.entity.Transaction;
import com.example.Library_management_system.enums.CardStatus;
import com.example.Library_management_system.enums.TransactionStatus;
import com.example.Library_management_system.repository.BookRepository;
import com.example.Library_management_system.repository.CardRepository;
import com.example.Library_management_system.repository.TransactionRepository;
import com.example.Library_management_system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    private JavaMailSender emailSender;

    @Override
    public IssueBookResponseDto issueBook(IssueBookRequestDto issueBookRequestDto) throws Exception {

        Transaction transaction = new Transaction();

        transaction.setTransactionNumber(String.valueOf(UUID.randomUUID()));
        transaction.setIssueOperation(true);

        Card card;
        try{
            card = cardRepository.findById(issueBookRequestDto.getCardId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid card id!!!");
        }

        transaction.setCard(card);

        Book book;
        try{
            book = bookRepository.findById(issueBookRequestDto.getBookId()).get();
        }
        catch (Exception e){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Invalid Book id!!!!");
        }

        transaction.setBook(book);

        if(card.getCardStatus()!= CardStatus.ACTIVATED){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Card is not Active!!!");
        }

        if(book.isIssued()==true){
            transaction.setTransactionStatus(TransactionStatus.FAILED);
            transactionRepository.save(transaction);
            throw new Exception("Book is not available!!!");
        }

        transaction.setTransactionStatus(TransactionStatus.SUCCESS);
        book.setIssued(true);
        book.setCard(card);
        book.getTransactionList().add(transaction);

        card.getBooksIssued().add(book);
        card.getTransactionList().add(transaction);

        cardRepository.save(card); // save card, book and transaction.

        // prepare response dtp;

        IssueBookResponseDto issueBookResponseDto = new IssueBookResponseDto();
        issueBookResponseDto.setBookName(book.getTitle());
        issueBookResponseDto.setTransactionNumber(transaction.getTransactionNumber());
        issueBookResponseDto.setTransactionStatus(transaction.getTransactionStatus());


        String text = "Congratulation "+ card.getStudent().getName() + " you have been issue the book "+book.getTitle();


        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("demomail7875@gmail.comm");
        message.setTo(card.getStudent().getMobNo());
        message.setSubject("Issued Book");
        message.setText(text);
        emailSender.send(message);

        return issueBookResponseDto;
    }



    // return book api
}
