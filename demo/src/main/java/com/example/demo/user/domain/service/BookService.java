package com.example.demo.user.domain.service;

import com.example.demo.user.domain.model.entity.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookService {
    List<Book> getAll();
    Book create (Book book, Long userId);
    ResponseEntity<?> delete(Long bookId);
    List<Book> getByUserId (Long userId);
}
