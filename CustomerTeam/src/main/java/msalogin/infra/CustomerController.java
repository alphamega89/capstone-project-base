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
@RequestMapping(value = "/customers")
@Transactional
public class CustomerController {

    @Autowired
    CustomerService customerService;
    // keep

    //고객생성 (int customerId, String address, String telNo, String name, String juminNo);
    @RequestMapping(value = "/create/{customerId}/{Address}/{Telno}/{Name}/{JuminNo}", method = RequestMethod.POST)
    public void createCustomerSvc (
                                    @PathVariable(value = "customerId") int customerId, 
                                    @PathVariable(value = "Address") String Address,
                                    @PathVariable(value = "Telno") String Telno,
                                    @PathVariable(value = "Name") String Name,
                                    @PathVariable(value = "JuminNo") String JuminNo){
        System.out.println("#############Customer Controller : Create############");
        customerService.createCustomer(customerId, Address, Telno, Name, JuminNo);
    }

    //고객해지
    @RequestMapping(value = "/delete/{customerId}", method = RequestMethod.POST)
    public void deleteCustomerSvc (@PathVariable(value = "customerId") int customerId){
        System.out.println("#############Customer Controller : delete############");
        customerService.deleteCustomer(customerId);
    }

    //고객조회
    //@RestResource(exported = true)
    @RequestMapping(value = "/check/{customerId}", method = RequestMethod.GET)
    public Customer getCustomer(@PathVariable(value = "customerId") int customerId){
        System.out.println("#############Customer Controller method : getCustomer############"+customerId);
        return  this.customerService.getCustomer(customerId);
    }
}
