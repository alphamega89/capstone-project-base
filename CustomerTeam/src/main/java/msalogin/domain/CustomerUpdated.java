package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerUpdated extends AbstractEvent {

    private int customerId;
    private String status;

    public CustomerUpdated() {
        super();
    }
    // keep

}
