package msalogin.domain;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "Smartbanking_table")
@Data
public class Smartbanking {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    private String bankingId;

    private String password;

    private String status;
}
