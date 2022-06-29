package newaccount.domain;

import newaccount.domain.*;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "externalChecks",
    path = "externalChecks"
)
public interface ExternalCheckRepository
    extends PagingAndSortingRepository<ExternalCheck, Long> {

    Optional<ExternalCheck> findByRegNo(String regNo);}
