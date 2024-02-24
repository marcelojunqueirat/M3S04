package com.avalialivros.m3s04.service;

import com.avalialivros.m3s04.exceptions.PersonNotFoundException;
import com.avalialivros.m3s04.model.Book;
import com.avalialivros.m3s04.model.Person;
import com.avalialivros.m3s04.model.transport.BookDTO;
import com.avalialivros.m3s04.model.transport.operations.CreateBookDTO;
import com.avalialivros.m3s04.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookService.class);

    private BookRepository bookRepository;
    private PersonService personService;

    public BookService(BookRepository bookRepository, PersonService personService) {
        this.bookRepository = bookRepository;
        this.personService = personService;
    }

    @Transactional
    public BookDTO create(CreateBookDTO body, UserDetails userInSession) throws PersonNotFoundException {
        LOGGER.info("Iniciando a criação de um livro com o usuário de e-mail: {}", userInSession.getUsername());
        Person person = this.personService.findByEmail(userInSession.getUsername());
        Book book = this.bookRepository.save(new Book(body, person));
        LOGGER.info("Livro salvo, retornando-o...");
        return new BookDTO(book);
    }
}
