package co.edu.cue.GallegoShop.repositories;


import co.edu.cue.GallegoShop.domain.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

}
