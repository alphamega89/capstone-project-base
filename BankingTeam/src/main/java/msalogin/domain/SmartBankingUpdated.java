package msalogin.domain;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class SmartBankingUpdated extends AbstractEvent {
    @Id
    private int customerId;
    private String status;
    private String bankingId;
    private String password;

    public SmartBankingUpdated() {
        super();
    }
    // keep

}
