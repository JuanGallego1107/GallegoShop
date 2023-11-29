package co.edu.cue.GallegoShop.repositories;

import co.edu.cue.GallegoShop.domain.entities.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Admin,Integer> {
}
