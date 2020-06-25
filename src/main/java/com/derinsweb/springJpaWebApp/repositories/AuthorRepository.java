package com.derinsweb.springJpaWebApp.repositories;

import org.springframework.data.repository.CrudRepository;

import com.derinsweb.springJpaWebApp.domain.Author;


public interface AuthorRepository extends CrudRepository<Author, Long> {

}