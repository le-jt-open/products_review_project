package com.example.reviewing.window.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.reviewing.window.entity.Author;
import com.example.reviewing.window.entity.Product;
import com.example.reviewing.window.entity.Review;

@DataJpaTest
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void shouldCountProducts() {
        productRepository.save(new Product());
        productRepository.save(new Product());

        long count = productRepository.count();

        assertThat(count).isEqualTo(2);
    }

    @Test
    void shouldReturnTopProductsByPositiveReviews() {
        // AUTHORS
        Author author = createAuthor();

        // PRODUCT 1 (2 reviews positives)
        Product p1 = new Product();
        Review r1 = createReview(p1, author, 5); 

        Review r2 = createReview(p1, author,4); 

        p1.setReviews(List.of(r1, r2));

        // PRODUCT 2 (1 review positive)
        Product p2 = new Product();
        Review r3 = createReview(p2, author,5);

        p2.setReviews(List.of(r3));
        
        
        productRepository.saveAll(List.of(p1, p2));

        List<Product> result = productRepository
                .findTop5BestRatedProducts();

        assertThat(result).isNotEmpty();
        assertThat(result.get(0)).isNotNull();
    }
    
    @Test
    void shouldReturnTop5WorstProductsByPositiveReviews() {

        Author author = createAuthor();


        Product p1 = new Product();

        Review r1 = createReview(p1, author, 5);

        Review r2 = createReview(p1, author, 4);

        p1.setReviews(List.of(r1, r2));
        
        productRepository.save(p1);

        Product p2 = new Product();

        Review r3 = createReview(p2, author, 5);

        p2.setReviews(List.of(r3));

        productRepository.save(p2);
        
        Product p3 = new Product();

        // NOT positive (<3)
        Review r4 = createReview(p3, author, 2);

        p3.setReviews(List.of(r4));

        productRepository.save(p3);
        
        List<Product> result = productRepository
                .findTop5WorstRatedProducts();

        assertThat(result).isNotEmpty();

        // Le pire produit doit être celui avec 0 review positive (1 review negative)
        assertThat(result.get(0).getId()).isEqualTo(p3.getId());

        // Ensuite celui avec 2 positives avec moyenne de 4.5
        assertThat(result.get(1).getId()).isEqualTo(p1.getId());

        // Puis celui avec 1 positive avec moyenne de 5
        assertThat(result.get(2).getId()).isEqualTo(p2.getId());
    }

	private Review createReview(Product productParam, Author authorParam, int notationParam) {
		Review reviewLocal = new Review();
		reviewLocal.setNotation(notationParam);
		reviewLocal.setProduct(productParam);
		reviewLocal.setAuthor(authorParam);
		return reviewLocal;
	}
	
	private Author createAuthor() {
		Author author = new Author();
		author.setFirstName("John");
		author.setLastName("Doe");
		author.setType("professional");
		return author;
	}
}