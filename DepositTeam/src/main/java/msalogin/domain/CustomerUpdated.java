package msalogin.domain;

import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerUpdated extends AbstractEvent{

    private int customerId;
    private String status;

    public CustomerUpdated() {
        super();
    }
    // keep
}
