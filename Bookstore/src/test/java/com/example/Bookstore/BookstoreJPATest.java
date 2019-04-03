package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookstoreJPATest {

	 @Autowired
	    private BookRepository repository;
	 	private CategoryRepository crepository;
	 	
	 @Test
	    public void findByTitleShouldReturnBook() {
	        List<Book> books = repository.findByTitle("java");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getAuthor()).isEqualTo("Sauli");
	    }
	 
	 @Test
	    public void createNewBook() {
	    	Book book = new Book("testaus", "Joonas Jalonen", "2012", "12534", 29.00, new Category("IT", null) );
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }   
	 
	 @Test
	 	public void deleteBook() {
		 List<Book> books = repository.findByTitle("java");
	        
	        assertThat(books).hasSize(1);
	        repository.delete(books.get(0));
	        
	        List<Book> deletedbook = repository.findByTitle("java");
	        
	        assertThat(deletedbook).hasSize(0);
		 
	 }
	 
	 @Test
	    public void findByNameShouldReturnCategory() {
	        List<Category> categories = crepository.findByName("IT");
	        
	        assertThat(categories).hasSize(1);
	        assertThat(categories.get(0).getName()).isEqualTo("IT");
	 }
	
}