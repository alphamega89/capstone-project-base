package msalogin.domain;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SmartbankingServiceImp implements SmartbankingService{
    
    @Autowired
    private final SmartbankingRepository smartbankingRepository;

    //스마트폰뱅킹 신규
    public void createSmartBanking (int customerId, String bankingId, String password){
        System.out.println("#########Smartbanking Service : Start Register SmartbankingService#######");
        //신규된 고객 obj 확인
        Optional<Smartbanking> smartbankingOptional = smartbankingRepository.findBycustomerId(customerId);
        Smartbanking smartBankingCust = smartbankingOptional.get();
        //스마트폰뱅킹 신규 가입 정보 셋팅
        smartBankingCust.setBankingId(bankingId);
        smartBankingCust.setPassword(password);
        String custStatus = "1";
        smartBankingCust.setStatus(custStatus);
        //DB저장
        smartbankingRepository.save(smartBankingCust);

        //이벤트발행
        SmartBankingUpdated smartBankingCustEvt = new SmartBankingUpdated();
        smartBankingCustEvt.setCustomerId(customerId);
        smartBankingCustEvt.setBankingId(bankingId);
        smartBankingCustEvt.setPassword(password);
        smartBankingCustEvt.setStatus(custStatus);
        smartBankingCustEvt.publishAfterCommit();

    }

    //스마트폰뱅킹 해지
    public void deleteSmartBanking (int customerId){
        System.out.println("#########Smartbanking Service : Start Delete SmartbankingService#######");
        //고객 obj 확인
        Optional<Smartbanking> smartbankingOptional = smartbankingRepository.findBycustomerId(customerId);
        Smartbanking smartBankingCust = smartbankingOptional.get();
        //스마트폰뱅킹 고객 상태 정보 셋팅
        String custStatus = "9";
        smartBankingCust.setStatus(custStatus);
        //DB저장
        smartbankingRepository.save(smartBankingCust);

        //이벤트발행
        SmartBankingUpdated smartBankingCustEvt = new SmartBankingUpdated();
        smartBankingCustEvt.setCustomerId(customerId);
        smartBankingCustEvt.setStatus(custStatus);
        smartBankingCustEvt.publishAfterCommit();

    }

    //조회
    public Smartbanking getSmartBanking(int customerId){
        
        System.out.println("#########Smartbanking Service : Start get SmartbankingService#######");
        Optional<Smartbanking> smartbankingOptional = smartbankingRepository.findBycustomerId(customerId);
        System.out.println("#########Get Smartbanking obj############"+smartbankingOptional);
        Smartbanking smartBankingCust = smartbankingOptional.get();

        return smartBankingCust;
    }


    public Smartbanking save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Smartbanking smartBankingCust = null;
        try {
            smartBankingCust = mapper.readValue(data, Smartbanking.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*
        List<CustomerOption> customerOptions = customer.getCustomerOptions();
        for(CustomerOption c : customerOptions){
            c.setCustomerId(customer);
        }
        
         */
        return smartbankingRepository.save(smartBankingCust);

    }

}