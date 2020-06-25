package com.derinsweb.springJpaWebApp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.derinsweb.springJpaWebApp.domain.Author;
import com.derinsweb.springJpaWebApp.domain.Book;
import com.derinsweb.springJpaWebApp.domain.Publisher;
import com.derinsweb.springJpaWebApp.repositories.AuthorRepository;
import com.derinsweb.springJpaWebApp.repositories.BookRepository;
import com.derinsweb.springJpaWebApp.repositories.PublisherRepository;



@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
	

	 @Override
	    public void run(String... args) throws Exception {
		 	System.out.println("Started in Bootstrap");

		 	Publisher publisher = new Publisher();
		 	publisher.setName("DJ Publishing");
		 	publisher.setCity("Dallas");
		 	publisher.setState("TX");
		 	
		 	publisherRepository.save(publisher);
		    
		 	System.out.println("Publisher Count: " + publisherRepository.count());
		    
		 	
	        Author eric = new Author("Eric", "Evans");
	        Book ddd = new Book("Domain Driven Design", "123123");
	        eric.getBooks().add(ddd);
	        ddd.getAuthors().add(eric);

	        ddd.setPublisher(publisher);
	        publisher.getBooks().add(ddd);
	        
	        authorRepository.save(eric);
	        bookRepository.save(ddd);
	        publisherRepository.save(publisher);

	        Author rod = new Author("Rod", "Johnson");
	        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
	        rod.getBooks().add(noEJB);
	        noEJB.getAuthors().add(rod);
	        
	        noEJB.setPublisher(publisher);
	        publisher.getBooks().add(noEJB);

	        authorRepository.save(rod);
	        bookRepository.save(noEJB);
	        publisherRepository.save(publisher);
	        
	        System.out.println("Number of Books: " + bookRepository.count());
	        System.out.println("Publisher Number of books: " + publisher.getBooks().size());
	    }
}
