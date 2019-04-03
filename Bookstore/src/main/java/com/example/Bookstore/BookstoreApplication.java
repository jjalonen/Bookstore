package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository crepository,
			UserRepository userRepository) {
		return (args) -> {

			Category c1 = new Category();
			c1.setName("IT");
			crepository.save(c1);

			Category c2 = new Category();
			c2.setName("Business");
			crepository.save(c2);

			Category c3 = new Category();
			c3.setName("Fiction");
			crepository.save(c3);

			repository.save(new Book("java", "Sauli", "2012", "12213", 20.00, c1));
			repository.save(new Book("react", "Sauli", "2012", "12215", 25.00, c1));

			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");

			userRepository.save(user1);
			userRepository.save(user2);

			// listaa new Bookkiin tietoja sen mukaan mitä Book classissä on tietueita
			// Book book = new Book("Kirja1", "Juslin", "2019", "15515", "12", "")
			// repository.save(book);
		};
	}

}
