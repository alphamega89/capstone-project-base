package newaccount.domain;

import newaccount.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "accountopen", path = "accountopen")
public interface AccountARepository
    extends PagingAndSortingRepository<AccountA, Long> {}
