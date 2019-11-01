package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.comments.Comments;
import com.udacity.course3.reviews.domain.comments.CommentsRepository;
import com.udacity.course3.reviews.domain.products.Products;
import com.udacity.course3.reviews.domain.products.ProductsRepository;
import com.udacity.course3.reviews.domain.reviews.Reviews;
import com.udacity.course3.reviews.domain.reviews.ReviewsRepository;
import com.udacity.course3.reviews.domainMongo.products.*;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ProductsRepository pRepository, CommentsRepository cRepository,
								   ReviewsRepository rRepository, ProductRepositoryMongo pmRepository) {
		return args -> {

			//save some product reviews for MySQL
			Products product1 = new Products();
			product1.setProductName("smart watches");
			product1.setPrice("$199");

			//save products in the ProductsRepository
			product1 = pRepository.save(product1);
			System.err.println("Product1: " + product1);

			Reviews review1 = new Reviews();
			review1.setProduct(product1);
			Comments comment1 = new Comments();
			comment1.setCommentType("very good");
			comment1.setCommentDetail("works perfect");
			//save comments in the CommentsRepository
			comment1 = cRepository.save(comment1);
			review1.setComment(comment1);
			review1 = rRepository.save(review1);

			//create comment2
			Comments comment2 = new Comments();
			comment2.setCommentType("good");
			comment2.setCommentDetail("stylish outlook");
			comment2 = cRepository.save(comment2);
			rRepository.updateReviewForComment(product1.getID(), comment2.getId());

			Products product2 = new Products();
			product2.setProductName("Lego toys");
			product2.setPrice("$50");
			product2 = pRepository.save(product2);
			System.err.println("Product2: " + product2);

			Reviews review2 = new Reviews();
			review2 = rRepository.save(review2);

			//create comment1
			Comments comment3 = new Comments();
			comment3.setCommentType("very good");
			comment3.setCommentDetail("enhances creative idea");
			comment3 = cRepository.save(comment3);
			rRepository.updateReviewForComment(product2.getID(), comment3.getId());

			//create comment2
			Comments comment4 = new Comments();
			comment4.setCommentType("good");
			comment4.setCommentDetail("kids get more involved");
			comment4 = cRepository.save(comment4);
			rRepository.updateReviewForComment(product2.getID(), comment4.getId());


			//save some product reviews for mongoDB
			ProductsMongo product3 = new ProductsMongo();
			product3.setProductName("smart watches");
			product3.setPrice("$199");
			List<String> reviewIds = new ArrayList<>();

			ReviewsMongo review13 = new ReviewsMongo();

			//get a list of comments for review13
			List<CommentsMongo> comments13 = new ArrayList<>();
			CommentsMongo comment113 = new CommentsMongo();
			comment113.setCommentType("very good");
			comment113.setCommentDetail("works perfect");
			comments13.add(comment113);

			CommentsMongo comment213 = new CommentsMongo();
			comment213.setCommentType("good");
			comment213.setCommentDetail("stylish outlook");
			comments13.add(comment213);

			review13.setComments(comments13);
			reviewIds.add(review13.getId());

			ReviewsMongo review23 = new ReviewsMongo();
			//get a list of comments for review13
			List<CommentsMongo> comments23 = new ArrayList<>();
			CommentsMongo comment123 = new CommentsMongo();
			comment123.setCommentType("nice");
			comment123.setCommentDetail("affordable");
			comments23.add(comment123);

			review23.setComments(comments23);
			reviewIds.add(review23.getId());

			product3.setReviewId(reviewIds);
			//save products in the ProductsRepositoryMongo
			product3 = pmRepository.save(product3);
			System.err.println("Product3: " + product3);
		};
	}

}