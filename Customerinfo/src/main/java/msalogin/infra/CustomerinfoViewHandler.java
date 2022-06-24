package msalogin.infra;

import msalogin.domain.*;
import msalogin.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerinfoViewHandler {

    @Autowired
    private CustomerinfoRepository customerinfoRepository;

    //고객 상태 변경(신규, 해지)
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_Update_1(@Payload CustomerUpdated customerUpdated) {
        try {
            System.out.println("#########Customer Info Policy handler : CREATE##########");
            if (!customerUpdated.validate()) return;

            // view 객체 생성
            Customerinfo customerinfo = new Customerinfo();
            // view 객체에 이벤트의 Value 를 set 함
            //고객 상태 && 고객 신규인 경우만 (== "1") 계좌 DB에 데이터 insert
            if("1".equals(customerUpdated.getStatus())){
                System.out.println("#########Customer Info Policy handler : Register##########");
                customerinfo.setCustomerId(customerUpdated.getCustomerId());
                customerinfo.setCustomerStatus(customerUpdated.getStatus());
            }
            //고객 상태가 해지(== "9") 인 경우 계좌 DB에 상태 변경 
            else if("9".equals(customerUpdated.getStatus())){
                System.out.println("#########Customer Info Policy handler : Cancelled##########");
                customerinfo.setCustomerStatus(customerUpdated.getStatus()); 
            }
            // view 레파지토리에 save
            System.out.println("#########Customer Info Policy handler : CREATE Obj##########" + customerinfo);
            customerinfoRepository.save(customerinfo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //스마트폰뱅킹상태변경
    @StreamListener(KafkaProcessor.INPUT)
    public void whenSmartBankingUpdated_then_UPDATE_2(@Payload SmartBankingUpdated smartBankingUpdated) {
        try {
            System.out.println("#########Customer Info Policy handler : WHEN SMARTBANKING UPDATED##########");
            if (!smartBankingUpdated.validate()) return;
                // view 객체 조회
                Optional<Customerinfo> customerinfoOptional = customerinfoRepository.findBycustomerId(smartBankingUpdated.getCustomerId());

            if( customerinfoOptional.isPresent()) {
                 Customerinfo customerinfo = customerinfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerinfo.setBankingStatus(smartBankingUpdated.getStatus());  
                // view 레파지 토리에 save
                System.out.println("#########Customer Info Policy handler : Update(SmartBanking Update) Obj##########" + customerinfo);
                customerinfoRepository.save(customerinfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //계좌 상태 변경
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccountUpdated_then_UPDATE_3(@Payload AccountUpdated accountUpdated) {
        try {
            System.out.println("#########Customer Info Policy handler : WHEN ACCOUNT UPDATED##########");
            if (!accountUpdated.validate()) return;
                // view 객체 조회
                Optional<Customerinfo> customerinfoOptional = customerinfoRepository.findBycustomerId(accountUpdated.getCustomerId());

            if( customerinfoOptional.isPresent()) {
                Customerinfo customerinfo = customerinfoOptional.get();
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                customerinfo.setAccountNo(accountUpdated.getAccountNo());
                customerinfo.setAccountBal(accountUpdated.getAccountBal());
                customerinfo.setAccountStatus(accountUpdated.getAccountStatus());
                // view 레파지 토리에 save
                System.out.println("#########Customer Info Policy handler : Update(Account Status Update) Obj##########" + customerinfo);
                customerinfoRepository.save(customerinfo);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

