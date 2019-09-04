package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Reclamation;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.ReclamationRepository;

public class Query implements GraphQLQueryResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private ReclamationRepository reclamationRepository;
    

    public Query(AuthorRepository authorRepository, BookRepository bookRepository, ReclamationRepository reclamationRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.reclamationRepository = reclamationRepository;
    }

    public Iterable<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Iterable<Author> findAllAuthors() {
        return authorRepository.findAll();
    }
    
    public Iterable<Reclamation> findAllReclamations() {
        return reclamationRepository.findAll();
    }
    public long countBooks() {
        return bookRepository.count();
    }
    public long countAuthors() {
        return authorRepository.count();
    }
  
    public long countReclamations() {
        return reclamationRepository.count();
    }
    
}
