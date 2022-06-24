package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class SmartBankingUpdated extends AbstractEvent {

    private int CustomerId;
    private String Status;
    private String bankingId;
    private String password;
    // keep

}
