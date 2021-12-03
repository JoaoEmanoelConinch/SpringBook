package br.com.senior.springbook.model.book;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {

	@Id
	private Long id;

	@Column
	private String nome;
	@Column
	private String sinopse;
	@Column
	private String autor;
	@Column
	private Double preco;

	public Book(Long id, String nome, String sinopse, String autor, Double preco) {
		super();
		this.id = id;
		this.nome = nome;
		this.sinopse = sinopse;
		this.autor = autor;
		this.preco = preco;
	}

	public Book() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

}
