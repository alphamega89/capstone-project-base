package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "dashboard_table")
@Data
public class AppliedResultR {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String custNo;
    private String appliedStatus;
    private Long incomeAmount;
}
