package msalogin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import msalogin.LoginApplication;
import msalogin.domain.LoginSucceeded;

@Entity
@Table(name = "Login_table")
@Data
public class Login {

    private String bankingId;

    private String password;

    private String customerStatus;

    private String bankingStatus;

    @Id
    @Column(name = "customer_id")
    private int customerId;

    private String accountNum;

    private String accountBal;

    private String accountStatus;

    private Boolean islogin;

}
