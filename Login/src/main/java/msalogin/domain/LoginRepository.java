package msalogin.domain;

import msalogin.domain.*;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RepositoryRestResource(collectionResourceRel = "logins", path = "logins")
public interface LoginRepository extends CrudRepository<Login, String> {
    
    Optional<Login> findBycustomerId(int customerId);
    Optional<Login> findBybankingId(String bankingId);
}


