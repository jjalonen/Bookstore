package com.example.Bookstore.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Book {
    
    private Long id;
    private String title;
    private String author;
    private String year;
    private String isbn;
    private double price;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;

    public Book() {
    }


    public Book(String title, String author, String year, String isbn, double price, Category category) {
        super();
    	this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
        
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public Category getCategory() {
		return category;
    }
		public void setCategory(Category category) {
			this.category = category;
    }

    @Override
	public String toString() {
		if (this.category != null)
			return "Book [title=" + title + ", author= " + author + ", year= " + year + ", isbn= " + isbn + "]" + this.getCategory() + "]";		
		else
        return "Book [title=" + title + ", author= " + author + ", year= " + year + ", isbn= " + isbn + "]";
    }
}