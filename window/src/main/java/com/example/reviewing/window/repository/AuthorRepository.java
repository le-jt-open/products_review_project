package com.example.reviewing.window.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.reviewing.window.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
	Optional<Author> findByFirstNameAndLastName(String firstName, String lastName);
}
