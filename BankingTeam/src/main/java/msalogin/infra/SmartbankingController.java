package msalogin.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import msalogin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/smartbankings")
@Transactional
public class SmartbankingController {

    @Autowired
    SmartbankingService smartbankingService;
    // keep

    //스마튼폰뱅킹 신규 (String customerId, String bankingId, String password, String status);
    @RequestMapping(value = "/create/{customerId}/{bankingId}/{password}", method = RequestMethod.POST)
    public void createSmartBankingSvc (
                                    @PathVariable(value = "customerId") int customerId,
                                    @PathVariable(value = "bankingId") String bankingId,
                                    @PathVariable(value = "password") String password){
        System.out.println("#############SmartbankingService Controller : Create############");
        smartbankingService.createSmartBanking(customerId, bankingId, password);
    }

    //고객해지
    @RequestMapping(value = "/delete/{customerId}", method = RequestMethod.POST)
    public void deleteSmartBankingSvc (@PathVariable(value = "customerId") int customerId){
        System.out.println("#############SmartbankingService Controller : delete############");
        smartbankingService.deleteSmartBanking(customerId);
    }

    //고객조회
    //@RestResource(exported = true)
    @RequestMapping(value = "/check/{customerId}", method = RequestMethod.GET)
    public Smartbanking getSmartBanking(@PathVariable(value = "customerId") int customerId){
        System.out.println("#############SmartbankingService Controller method : getCustomer############"+customerId);
        return  this.smartbankingService.getSmartBanking(customerId);
    }
}
