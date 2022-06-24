package msalogin.infra;

import msalogin.domain.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

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
    AccountRepository accountRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void when_CustomerRegister_then_CREATE_1(@Payload CustomerUpdated customerUpdated) {
        
        System.out.println("#############when_CustomerUpdate_then_CREATE_1_Start###############");
        if (!customerUpdated.validate()) return;

        Account Accountdata = new Account();

        //DB에 저장할 정보 셋팅
        //고객 상태 && 고객 신규인 경우만 (== "1") 계좌 DB에 데이터 insert
        if("1".equals(customerUpdated.getStatus())){
            Accountdata.setCustomerId(customerUpdated.getCustomerId());
        }
        //고객 상태가 해지(== "9") 인 경우 계좌 DB에 상태 변경 
        else if("9".equals(customerUpdated.getStatus())){
            Accountdata.setAccountStatus(customerUpdated.getStatus());
        }
        
        //DB저장
        accountRepository.save(Accountdata);
        System.out.println("#############when_CustomerUpdate_then_CREATE_1_END###############");

    }

}
