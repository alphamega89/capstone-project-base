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
@RequestMapping(value = "/logins")
@Transactional
public class LoginController {

    @Autowired
    LoginService loginService;

    //스마트폰뱅킹 ID& Password 검증
    @RequestMapping(value = "/validate/{bankingId}/{password}", method = RequestMethod.GET)
    public void loginValidateSvc (@PathVariable(value = "bankingId") String bankingId, 
                                    @PathVariable(value = "password") String password){
        System.out.println("#############Login Controller : Checking ID&&PASSWORD############");
        loginService.loginValidate(bankingId, password);
    }



}
