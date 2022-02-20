package co2103.hw2.repo;

import org.springframework.data.repository.CrudRepository;

import co2103.hw2.model.Property;

public interface PropertyRepository extends CrudRepository<Property, Integer> {

}
