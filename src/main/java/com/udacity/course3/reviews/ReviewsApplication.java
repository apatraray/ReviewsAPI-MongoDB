package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domainMongo.products.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
//@EnableJpaRepositories
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabaseMongo(ProductRepositoryMongo pmRepository,
								   ReviewRepositoryMongo rmRepository, CommentRepositoryMongo cmRepository) {
		return args -> {

			ProductsMongo product3 = new ProductsMongo();
			product3.setProductName("smart watches");
			product3.setPrice("$199");
			System.err.println("ProductMongo: " + product3);
			List<String> reviewIds = new ArrayList<>();

			ReviewsMongo review13 = new ReviewsMongo();

			//get a list of comments for review13
			List<CommentsMongo> comments13 = new ArrayList<>();
			CommentsMongo comment113 = new CommentsMongo();
			comment113.setCommentType("very good");
			comment113.setCommentDetail("works perfect");
			comments13.add(comment113);
			cmRepository.save(comment113);

			CommentsMongo comment213 = new CommentsMongo();
			comment213.setCommentType("good");
			comment213.setCommentDetail("stylish outlook");
			comments13.add(comment213);
			cmRepository.save(comment213);

			review13.setComments(comments13);
			rmRepository.save(review13);
			System.err.println("review13: " + review13);
			reviewIds.add(review13.getId());

			ReviewsMongo review23 = new ReviewsMongo();
			//get a list of comments for review13
			List<CommentsMongo> comments23 = new ArrayList<>();
			CommentsMongo comment123 = new CommentsMongo();
			comment123.setCommentType("nice");
			comment123.setCommentDetail("affordable");
			comments23.add(comment123);
			cmRepository.save(comment213);

			review23.setComments(comments23);
			rmRepository.save(review23);
			reviewIds.add(review23.getId());
			System.err.println("review23: " + review23);

			product3.setReviewId(reviewIds);
			//save products in the ProductsRepositoryMongo
			product3 = pmRepository.save(product3);
			System.err.println("Product3: " + product3);
		};
	}

}