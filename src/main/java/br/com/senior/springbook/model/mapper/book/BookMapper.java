package br.com.senior.springbook.model.mapper.book;

import org.springframework.stereotype.Service;

import br.com.senior.springbook.model.book.Book;
import br.com.senior.springbook.model.dto.book.BookDto;

@Service
public class BookMapper {

    public BookDto toDto(Book book) {
        var BookDto = new BookDto();
        BookDto.nome = book.getNome();
        BookDto.autor = book.getAutor();
        BookDto.sinopse = book.getSinopse();
        BookDto.preco = book.getPreco();
        return BookDto;
    }

    public Book toBook(BookDto bookDto) {
        var book = new Book();
        book.setNome(bookDto.nome);
        book.setAutor(bookDto.autor);
        book.setSinopse(bookDto.sinopse);
        book.setPreco(bookDto.preco);
        return book;
    }

}
