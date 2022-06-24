package msalogin.domain;


import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Customer_table")
@Data
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    private String status;

    private String address;

    private String telNo;

    private String name;

    private String juminNo;

}
