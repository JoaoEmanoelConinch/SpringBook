package br.com.senior.springbook.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import br.com.senior.springbook.model.book.Book;
import br.com.senior.springbook.service.book.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

	  @Autowired
	    private BookService bookService;

	    @PostMapping()
	    public ResponseEntity<Book> addPessoa(@RequestBody Book book){
	    	Book newBook = bookService.addBook(book);
	        return new ResponseEntity<>(newBook, HttpStatus.CREATED);
	    }

	    @PutMapping()
	    public ResponseEntity<Book> updatePessoa(@RequestBody Book book){
	    	Book updateBook = bookService.updateBook(book);
	        return new ResponseEntity<>(updateBook, HttpStatus.OK);
	    }

	    @GetMapping()
	   public ResponseEntity<List<Book>> listarBook(){ List<Book> listar = bookService.findAll();
	        return new ResponseEntity<>(listar, HttpStatus.OK);

	 }

	    @GetMapping("{id}")
	    public ResponseEntity<List<Book>> listarBookId(@PathVariable("id") Long id){
	        List<Book> books = bookService.findBookById(id);
	        return new ResponseEntity<>(books, HttpStatus.OK);
	    }

	    @DeleteMapping("{id}")
	    public void deletar(@PathVariable("id") Long id){
	         bookService.deleteBook(id);
	    }
}
