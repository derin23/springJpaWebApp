package com.derinsweb.springJpaWebApp.repositories;


import org.springframework.data.repository.CrudRepository;

import com.derinsweb.springJpaWebApp.domain.Book;


public interface BookRepository extends CrudRepository<Book, Long>{

}
