package msalogin.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;


import lombok.Data;
import msalogin.infra.AbstractEvent;

@Data
public class AccountUpdated extends AbstractEvent {
    @Id
    @Column(name = "customer_id")
    private int CustomerId;
    private String AccountNo;
    private String AccountBal;
    private String AccountStatus;
    private String TrnsCode;
}
