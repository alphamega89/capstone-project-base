package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class AccountUpdated extends AbstractEvent {

    private int CustomerId;
    private String AccountNo;
    private String AccountBal;
    private String AccountStatus;
    private String TrnsCode;
    // keep

}
