package com.example.reviewing.window.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.reviewing.window.entity.Product;
import com.example.reviewing.window.repository.ProductRepository;
import com.example.reviewing.window.service.impl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    @Test
    void shouldReturnProductCount() {
        when(productRepository.count()).thenReturn(10L);

        long result = productService.countProducts();

        assertThat(result).isEqualTo(10);
    }

    @Test
    void shouldReturnAllProducts() {
        List<Product> productList = List.of(generateProduct(0L, "Test zero"), generateProduct(1L, "Test"));
		when(productRepository.findAll()).thenReturn(productList);

        var result = productService.getAllProducts();

        assertThat(result).hasSize(productList.size());
    }
    

	@Test
	void shouldReturnTop5BestProducts() {
	    Product p = generateProduct(1L, null);
	
	    when(productRepository.findTop5BestRatedProducts())
	            .thenReturn(List.of(p));
	
	    var result = productService.getHighestRated();
	    assertThat(result).hasSize(1);
	}

    
    private Product generateProduct(long idParam, String nameParam) {
    	Product product = new Product();
    	product.setId(idParam);
    	product.setName(nameParam);
		return product;
    }
}