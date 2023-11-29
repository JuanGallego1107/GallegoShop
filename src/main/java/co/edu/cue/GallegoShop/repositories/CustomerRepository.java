package co.edu.cue.GallegoShop.repositories;

import co.edu.cue.GallegoShop.domain.entities.Customer;
import co.edu.cue.GallegoShop.mapper.dtos.CustomerDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
