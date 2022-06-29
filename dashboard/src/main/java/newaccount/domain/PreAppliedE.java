package newaccount.domain;

import java.util.Date;
import lombok.Data;
import newaccount.infra.AbstractEvent;

@Data
public class PreAppliedE extends AbstractEvent {

    private Long id;
    private String appliedStatus;
    private String custNo;
    private String regNo;
}
