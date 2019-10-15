package com.udacity.course3.reviews;

import com.udacity.course3.reviews.domain.comments.Comments;
import com.udacity.course3.reviews.domain.comments.CommentsRepository;
import com.udacity.course3.reviews.domain.products.Products;
import com.udacity.course3.reviews.domain.products.ProductsRepository;
import com.udacity.course3.reviews.domain.reviews.Reviews;
import com.udacity.course3.reviews.domain.reviews.ReviewsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReviewsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewsApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(ProductsRepository pRepository, CommentsRepository cRepository, ReviewsRepository rRepository) {
		return args -> {
		//save some product reviews
			Products product1 = new Products();
			product1.setProductName("smart watches");
			product1.setPrice("$199");

			//save products in the ProductsRepository
			product1 = pRepository.save(product1);
			System.err.println("Product1: " + product1);

			Reviews review1 = new Reviews();
			review1.setProductId(product1.getID());
			review1 = rRepository.save(review1);

			Comments comment1 = new Comments();
			comment1.setCommentType("very good");
			comment1.setCommentDetail("works perfect");
			//save comments in the CommentsRepository
			comment1 = cRepository.save(comment1);
			rRepository.updateReviewForComment(product1.getID(), comment1.getId());

			//create comment2
			Comments comment2 = new Comments();
			comment2.setCommentType("good");
			comment2.setCommentDetail("stylish outlook");
			comment2 = cRepository.save(comment2);
//			rRepository.save(review1);
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
		};
	}

}