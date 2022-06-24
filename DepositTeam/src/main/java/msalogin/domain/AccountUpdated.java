package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class AccountUpdated extends AbstractEvent {

    private String customerId;
    private String accountNo;
    private Double accountBal;
    private String accountStatus;
    private String trnsCode;

    public AccountUpdated() {
        super();
    }
    // keep

}
