package com.silcfcr.repositories;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.silcfcr.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByEmail(String email);
    List<User>findUsersByEmail(String email);
    Optional<User> findById( int id ); // SELECT * FROM languages WHERE identifier=id

	@SuppressWarnings("unchecked")
	User save( User user );
}

