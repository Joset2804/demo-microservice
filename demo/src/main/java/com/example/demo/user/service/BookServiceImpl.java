package com.example.demo.user.service;

import com.example.demo.shared.exception.ResourceNotFoundException;
import com.example.demo.user.domain.model.entity.Book;
import com.example.demo.user.domain.model.entity.User;
import com.example.demo.user.domain.persistence.BookRepository;
import com.example.demo.user.domain.persistence.UserRepository;
import com.example.demo.user.domain.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final static String ENTITY = "Book";

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book create(Book book, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with Id" + userId));
        book.setUser(user);
        return bookRepository.save(book);
    }

    @Override
    public ResponseEntity<?> delete(Long bookId) {
        return bookRepository.findById(bookId).map(book -> {
            bookRepository.delete(book);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, bookId));
    }

    @Override
    public List<Book> getByUserId(Long userId) {
        return bookRepository.findByUserId(userId);
    }
}
