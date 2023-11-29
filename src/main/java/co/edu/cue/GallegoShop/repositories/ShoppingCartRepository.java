package co.edu.cue.GallegoShop.repositories;


import co.edu.cue.GallegoShop.domain.entities.ShoppingCart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends CrudRepository<ShoppingCart,Integer> {
}
