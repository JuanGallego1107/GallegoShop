package co.edu.cue.GallegoShop.repositories;



import co.edu.cue.GallegoShop.domain.entities.CartItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartItemRepository extends CrudRepository<CartItem,Integer> {

}
