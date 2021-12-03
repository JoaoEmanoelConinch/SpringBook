package br.com.senior.springbook.repository.book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import br.com.senior.springbook.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	Optional<Book> findBookById(Long id);

}
