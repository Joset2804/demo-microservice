package com.example.demo.user.mapping;

import com.example.demo.shared.mapping.EnhancedModelMapper;
import com.example.demo.user.domain.model.entity.Book;
import com.example.demo.user.resource.BookResource;
import com.example.demo.user.resource.CreateBookResource;
import com.example.demo.user.resource.UpdateBookResource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookMapper {

    @Autowired
    private EnhancedModelMapper mapper;

    public BookResource toResource(Book model)
    {
        return mapper.map(model, BookResource.class);
    }

    public List<BookResource> toResource(List<Book> model)
    {
        return mapper.mapList(model, BookResource.class);
    }

    public Book toModel(CreateBookResource resource)
    {
        return mapper.map(resource, Book.class);
    }

    public Book toModel(UpdateBookResource resource)
    {
        return mapper.map(resource, Book.class);
    }
}
