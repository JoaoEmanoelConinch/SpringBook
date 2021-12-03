package br.com.senior.springbook.service.book;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.springbook.model.book.Book;
import br.com.senior.springbook.repository.book.BookRepository;



@Service
@Transactional
public class BookService {

	 @Autowired
	    private BookRepository repo;

	    public Book addBook(Book book) {
	        return repo.save(book);
	    }

	    public Book updateBook(Book book) {
	        return repo.save(book);
	    }

	    public List<Book> findAll() {
	        return repo.findAll();
	    }

	    public Optional<Book> findBookById(Long id) {
	        return repo.findBookById(id);
	    }

	    public void deleteBook(Long id) {
	        repo.deleteById(id);

	    }
}
