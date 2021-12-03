package br.com.senior.springbook.controller.book;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import br.com.senior.springbook.exceptions.BookException;
import br.com.senior.springbook.exceptions.BookExistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.senior.springbook.model.book.Book;
import br.com.senior.springbook.model.dto.book.BookDto;
import br.com.senior.springbook.model.mapper.book.BookMapper;
import br.com.senior.springbook.repository.book.BookRepository;
import br.com.senior.springbook.service.book.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper bookMapper;

    @PostMapping()
    public ResponseEntity<BookDto> add(@RequestBody BookDto bookDto) {

        if (bookDto.nome == null || bookDto.autor == null || bookDto.sinopse == null || bookDto.preco == null) {
            throw new BookException("Um dos campos do livro é inválido!");
        }

        Book book = bookMapper.toBook(bookDto);
        BookDto bookDtoResponse = bookMapper.toDto(repository.save(book));
        return ResponseEntity.ok().body(bookDtoResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<BookDto> put(@PathVariable("id") Long id, @RequestBody Book newBook) {
        Optional<Book> oldBook = repository.findById(id);
        if (oldBook.isPresent()) {
            Book book = oldBook.get();
            book.setNome(newBook.getNome());
            book.setAutor(newBook.getAutor());
            book.setSinopse(newBook.getSinopse());
            book.setPreco(newBook.getPreco());
            Book updateBook = bookService.updateBook(book);
            return new ResponseEntity<>(bookMapper.toDto(updateBook), HttpStatus.OK);
        }
        throw new BookExistenceException("O livro informado não existe no sistema!");
    }

    @GetMapping()
    public ResponseEntity<List<BookDto>> listarBook() {
        List<Book> listar = bookService.findAll();

        if (listar.isEmpty()) {
            throw new BookExistenceException("Não há nenhum livro cadastrado!");
        }

        List<BookDto> booksDto = listar.stream().map(bookMapper::toDto).collect(Collectors.toList());

        return ResponseEntity.ok().body(booksDto);
    }

    @GetMapping("{id}")
    public ResponseEntity<BookDto> listarBookId(@PathVariable("id") Long id) {
        Optional<Book> books = bookService.findBookById(id);
        if (books.isPresent()) {
            return new ResponseEntity<>(bookMapper.toDto(books.get()), HttpStatus.OK);
        }
        throw new BookExistenceException("O livro informado não existe no sistema!");
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") Long id) {
        Optional<Book> book = repository.findById(id);
        if (book.isPresent()) {
            bookService.deleteBook(id);
        } else {
            throw new BookExistenceException("O livro informado não existe no sistema!");
        }
    }
}
