package io.codementor.gtommee.restapispring.repositories;

import io.codementor.gtommee.restapispring.models.Pets;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PetsRepository extends MongoRepository<Pets, String> {
  Pets findBy_id(ObjectId _id);
}
