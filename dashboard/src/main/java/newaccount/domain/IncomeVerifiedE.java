package newaccount.domain;

import java.util.Date;
import lombok.Data;
import newaccount.infra.AbstractEvent;

@Data
public class IncomeVerifiedE extends AbstractEvent {

    private Long id;
    private String custNo;
    private String verifyResult;
    private Long incomeAmount;
    private String appliedStatus;
    private String regNo;
}
