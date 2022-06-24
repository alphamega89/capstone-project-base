package msalogin.domain;

import java.util.Date;

import javax.persistence.Id;


import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class CustomerUpdated extends AbstractEvent {
    @Id
    private int CustomerId;
    private String Status;
    // keep

}
