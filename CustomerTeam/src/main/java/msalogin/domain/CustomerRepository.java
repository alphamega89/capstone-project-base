package msalogin.domain;

import msalogin.domain.*;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RepositoryRestResource(collectionResourceRel = "customers", path = "customers")
public interface CustomerRepository extends CrudRepository<Customer, String> {
    Optional<Customer> findBycustomerId(int customerId);
}
