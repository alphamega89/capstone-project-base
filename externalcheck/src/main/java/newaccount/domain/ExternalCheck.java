package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newaccount.ExternalcheckApplication;

@Entity
@Table(name = "ExternalCheck_table")
@Data
public class ExternalCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String regNo;

    private Long incomeExtAmt;
 
     
    @PostPersist
    public void onPostPersist() {}

    public static ExternalCheckRepository repository() {
        ExternalCheckRepository externalCheckRepository = ExternalcheckApplication.applicationContext.getBean(
            ExternalCheckRepository.class
        );
        return externalCheckRepository;
    }
}
