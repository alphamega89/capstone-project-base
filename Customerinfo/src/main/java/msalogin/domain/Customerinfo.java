package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;


import lombok.Data;

@Entity
@Table(name = "Customerinfo_table")
@Data
public class Customerinfo {

    @Id
    @Column(name = "customer_id")
    private int customerId;
    private String customerStatus;
    private String bankingStatus;
    private String accountStatus;
    private String accountNo;
    private String accountBal;
}
