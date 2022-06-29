package newaccount.domain;

import java.util.Date;
import lombok.Data;
import newaccount.infra.AbstractEvent;

@Data
public class AccountOpenedE extends AbstractEvent {

    private Long id;
    private String acctNo;
    private String custNo;
    private String openDate;
    private String accountStatus;
    private String appliedStatus;
}
