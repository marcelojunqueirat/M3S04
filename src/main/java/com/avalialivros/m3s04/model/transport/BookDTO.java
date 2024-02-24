package com.avalialivros.m3s04.model.transport;


import com.avalialivros.m3s04.model.Book;
import com.avalialivros.m3s04.model.Rating;

import java.util.Set;

public record BookDTO(String guid,
                      String title,
                      PersonDTO createdBy,
                      Integer yearOfPublication,
                      Set<Rating> grades) {
    public BookDTO(Book book){
        this(book.getGuid(),
                book.getTitle(),
                new PersonDTO(book.getCreatedBy()),
                book.getYearOfPublication(),
                book.getGrades());
    }
}
