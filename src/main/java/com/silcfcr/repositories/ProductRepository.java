package com.silcfcr.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.silcfcr.models.Product;



@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	Optional<Product> findById( int id ); // SELECT * FROM languages WHERE identifier=id
	
//	????
	@SuppressWarnings("unchecked")
	Product save( Product product );
	
//	@Query( value="SELECT s.name, s.genre, s.lyrics, a.firstname, a.lastname " +
//			  "FROM songs s JOIN songs ON a.author_id = ab.author_id " +
//			  			     "JOIN books b ON b.book_id = ab.book_id", nativeQuery=true )
//	List<Object[]> selectSongsWithAuthors();
//	
//	@Query( value="SELECT b.name, b.pages, a.firstname, a.lastname " +
//			  "FROM authors a JOIN authors_books ab ON a.author_id = ab.author_id " +
//			  			     "JOIN books b ON b.book_id = ab.book_id", nativeQuery=true )
//List<Object[]> selectBooksAndAuthors();
   
}

