package msalogin.domain;

import java.util.Date;
import lombok.Data;
import msalogin.domain.*;
import msalogin.infra.AbstractEvent;

@Data
public class LoginSucceeded extends AbstractEvent {

    private String bankingId;
    private String customerNM;
    private String islogin;
    
    public LoginSucceeded() {
        super();
    }
    // keep

}
