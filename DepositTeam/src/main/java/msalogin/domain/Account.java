package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.DepositTeamApplication;
import msalogin.domain.AccountUpdated;

@Entity
@Table(name = "Account_table")
@Data
public class Account {

    @Id
    @Column(name = "customer_id")
    private String customerId;

    private String accountNo;

    private Double accountBal;

    private String accountStatus;

    private String trnsCode;
}
