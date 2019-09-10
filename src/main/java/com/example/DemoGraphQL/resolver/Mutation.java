package com.example.DemoGraphQL.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.DemoGraphQL.exception.BookNotFoundException;
import com.example.DemoGraphQL.model.Author;
import com.example.DemoGraphQL.model.Book;
import com.example.DemoGraphQL.model.Reclamation;
import com.example.DemoGraphQL.repository.AuthorRepository;
import com.example.DemoGraphQL.repository.BookRepository;
import com.example.DemoGraphQL.repository.ReclamationRepository;

public class Mutation implements GraphQLMutationResolver {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private ReclamationRepository reclamationRepository;

    public Mutation(AuthorRepository authorRepository, BookRepository bookRepository, ReclamationRepository reclamationRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.reclamationRepository = reclamationRepository;
        
    }

    public Author newAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);

        authorRepository.save(author);

        return author;
    }

    public Book newBook(String title, String isbn, Integer pageCount, Long authorId) {
        Book book = new Book();
        book.setAuthor(new Author(authorId));
        book.setTitle(title);
        book.setIsbn(isbn);
        book.setPageCount(pageCount != null ? pageCount : 0);

        bookRepository.save(book);

        return book;
    }
    
    public Reclamation newReclamation(String matricule, String nomClient, String adresseExp, String adresseDest) {
    	Reclamation reclamation = new Reclamation();
    	reclamation.setMatricule(matricule);
        reclamation.setNomClient(nomClient);
        reclamation.setAddresseExp(adresseExp);
        reclamation.setAdresseDest(adresseDest);
        
         
    	reclamationRepository.save(reclamation);
    	
    	return reclamation;
    }

    public boolean deleteBook(Long id) {
        bookRepository.delete(id);
        return true;
    }

    public Book updateBookPageCount(Integer pageCount, Long id) {
        Book book = bookRepository.findOne(id);
        if(book == null) {
            throw new BookNotFoundException("The book to be updated was found", id);
        }
        book.setPageCount(pageCount);

        bookRepository.save(book);

        return book;
    }
}
