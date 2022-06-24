package msalogin.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import msalogin.config.kafka.KafkaProcessor;
import msalogin.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    LoginRepository loginRepository;


    //WHEN CUSTOMER REGISTER && CANCELLED
    @StreamListener(KafkaProcessor.INPUT)
    public void when_CustomerRegister_then_UPdate_1(@Payload CustomerUpdated customerUpdated) {
        System.out.println("#############when_CustomerUPDATE_then_CREATE_1_Start###############");
        if (!customerUpdated.validate()) return;

        Login logindata = new Login();

        //DB에 저장할 정보 셋팅
        //고객 상태가 신규("1") 인 경우
        if("1".equals(customerUpdated.getStatus())){
            System.out.println("#############when_Customer UPDATE : Register###############");
            logindata.setCustomerId(customerUpdated.getCustomerId());
            logindata.setCustomerStatus(customerUpdated.getStatus());
        }
        //고객 상태가 해지("9") 인 경우
        else if("9".equals(customerUpdated.getStatus())){
            System.out.println("#############when_Customer UPDATE : Cancelled###############");
            logindata.setCustomerStatus(customerUpdated.getStatus());
        }
        
        //DB저장
        loginRepository.save(logindata);
        System.out.println("#############when_CustomerUPDATE_then_CREATE_1_END###############");

    }

    //WHEN Change SMARTBANKING Status
    @StreamListener(KafkaProcessor.INPUT)
    public void when_SmartBankingRegistered_then_Update_2(@Payload SmartBankingUpdated smartBankingUpdated) {
        System.out.println("#############when_SmartBankingRegistered_then_Update_2_Start###############");
        if (!smartBankingUpdated.validate()) return;

        //이벤트에서 전달된 고객번호로 Login DB에서 해당하는 Obj 찾아오기
        Optional<Login> logindataOption = loginRepository.findBycustomerId(smartBankingUpdated.getCustomerId());
        Login logindata = logindataOption.get();


        //이벤트에서 넘어온 상태값이 "1"인 경우 => 신규 
        if("1".equals(smartBankingUpdated.getStatus())){
            //스마트폰뱅킹 가입 정보 셋팅
            logindata.setBankingId(smartBankingUpdated.getBankingId());
            logindata.setPassword(smartBankingUpdated.getPassword());
            logindata.setBankingStatus(smartBankingUpdated.getStatus());
        } 
        //이벤트에서 넘어온 상태값이 "9"인 경우 => 해지
        else if ("9".equals(smartBankingUpdated.getStatus())){
            //스마트폰뱅킹 상태값만 변경
            logindata.setBankingStatus(smartBankingUpdated.getStatus());
        }

        //DB저장
        loginRepository.save(logindata);
        System.out.println("#############when_SmartBankingRegistered_then_Update_2_END###############");

    }

    //WHEN Change Account Status
    @StreamListener(KafkaProcessor.INPUT)
    public void when_AccountStatusChanged_then_Update_3(@Payload AccountUpdated accountUpdated) {
        System.out.println("#############when_AccountStatusChanged_then_Update_3_Start###############");
        if (!accountUpdated.validate()) return;
    
        //이벤트에서 전달된 고객번호로 Login DB에서 해당하는 Obj 찾아오기
        Optional<Login> logindataOption = loginRepository.findBycustomerId(accountUpdated.getCustomerId());
        Login logindata = logindataOption.get();
    
    
        //이벤트에서 넘어온 상태값이 "1"인 경우 => 신규 
        if("1".equals(accountUpdated.getAccountStatus())){
            //계좌 신규 정보 셋팅
            logindata.setAccountNum(accountUpdated.getAccountNo());
            logindata.setAccountBal(accountUpdated.getAccountBal());
            logindata.setAccountStatus(accountUpdated.getAccountStatus());
        } 
        //이벤트에서 넘어온 상태값이 "9"인 경우 => 해지
        else if ("9".equals(accountUpdated.getAccountStatus())){
            //계좌 상태값만 변경
            logindata.setAccountStatus(accountUpdated.getAccountStatus());
        }
        //이벤트에서 넘어온 거래구분코드가 "1"인 경우 => 입금
        else if ("1".equals(accountUpdated.getTrnsCode())){
            logindata.setAccountBal(accountUpdated.getAccountBal());
        }
        //이벤트에서 넘어온 거래구분코드가 "1"인 경우 => 입금
        else if ("2".equals(accountUpdated.getTrnsCode())){
            logindata.setAccountBal(accountUpdated.getAccountBal());
        }
    
        //DB저장
        loginRepository.save(logindata);
        System.out.println("#############when_AccountStatusChanged_then_Update_3_END###############");
    
    }

}
