package com.silcfcr.services;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.silcfcr.models.Product;
import com.silcfcr.repositories.ProductRepository;


@Service
public class ProductService {
    private final ProductRepository productRepository;
    
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product>getAll(){
		return productRepository.findAll();
	}
    
    
    
    // find user by id
    public Product findById(Long id) {
    	Optional<Product> product = productRepository.findById(id);
    	
    	if(product.isPresent()) {
            return product.get();
    	} else {
    	    return null;
    	}
    }
    
    public Product create(Product song) {
        return productRepository.save(song);
    }
    public Product edit(Product song) {
        return productRepository.save(song);
    }
    
    public void delete(Product song) {
       productRepository.delete(song);
    }
  
 
}
 