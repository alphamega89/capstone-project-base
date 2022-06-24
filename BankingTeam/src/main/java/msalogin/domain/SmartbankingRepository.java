package msalogin.domain;

import msalogin.domain.*;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RepositoryRestResource(collectionResourceRel = "smartbankings",path = "smartbankings")
public interface SmartbankingRepository extends CrudRepository<Smartbanking, String> {
    Optional<Smartbanking> findBycustomerId(int customerId);
}

