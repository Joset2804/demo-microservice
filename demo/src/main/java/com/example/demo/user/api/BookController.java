package com.example.demo.user.api;

import com.example.demo.user.domain.service.BookService;
import com.example.demo.user.mapping.BookMapper;
import com.example.demo.user.resource.BookResource;
import com.example.demo.user.resource.CreateBookResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Book")
@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper mapper;

    @GetMapping
    public List<BookResource> getAllBook() {
        return mapper.toResource(bookService.getAll());
    }

    @PostMapping("users/{userId}")
    public BookResource createBook(@PathVariable(name="userId") Long userId, @Valid @RequestBody CreateBookResource request)
    {
        return mapper.toResource(bookService.create(mapper.toModel(request), userId));
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Long bookId)
    {
        return bookService.delete(bookId);
    }

    @GetMapping("user/{userId}")
    public List<BookResource> getBookByUser(@PathVariable Long userId)
    {
        return mapper.toResource(bookService.getByUserId(userId));
    }
}
