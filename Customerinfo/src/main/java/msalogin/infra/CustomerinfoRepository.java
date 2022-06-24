package msalogin.infra;

import java.util.List;
import java.util.Optional;

import msalogin.domain.*;
import org.springframework.data.repository.CrudRepository;

public interface CustomerinfoRepository extends CrudRepository<Customerinfo, String> {
    //List<Customerinfo> findBycustomerId(String customerId);
    Optional<Customerinfo> findBycustomerId(int customerId);
    // keep

}

