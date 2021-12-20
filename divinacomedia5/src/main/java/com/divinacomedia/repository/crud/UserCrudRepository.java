package com.divinacomedia.repository.crud;

import com.divinacomedia.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Carlos A. Gil
 */
public interface UserCrudRepository extends MongoRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findTopByOrderByIdDesc();

    List<User> findByMonthBirthtDay(String month);
}
