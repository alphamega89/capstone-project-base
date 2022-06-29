package newaccount.domain;

import java.util.Date;
import java.util.Map;
import lombok.Data;
import newaccount.domain.*;
import newaccount.infra.AbstractEvent;

@Data
public class IncomeVerifiedE extends AbstractEvent {

    private Long id;
    private String custNo;
    private String verifyResult;
    private Long incomeAmount;
    private String appliedStatus;
    private String regNo;
    // keep

}
