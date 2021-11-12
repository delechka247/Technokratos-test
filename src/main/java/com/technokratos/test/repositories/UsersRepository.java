package com.technokratos.test.repositories;

import com.technokratos.test.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends MongoRepository<User, String> {
}
