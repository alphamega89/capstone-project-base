package msalogin.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    SmartbankingRepository smartbankingRepository;

    //
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCustomerRegistered_then_CREATE_1 (@Payload CustomerUpdated customerUpdated) {
        if (!customerUpdated.validate()) return;

        Smartbanking smartbaking = new Smartbanking();

        //고객 상태가 정상("1")인 경우만 신규된 고객 번호 DB insert
        if("1".equals(customerUpdated.getStatus())){
            smartbaking.setCustomerId(customerUpdated.getCustomerId());
        }
        //고객 상태가 해지("9")인 경우 전자금융 상태도 "9"로 변경
        else if ("9".equals(customerUpdated.getStatus())){
            smartbaking.setStatus(customerUpdated.getStatus());
        }

        System.out.println("#########Smartbanking Policy handler : CREATE Obj##########" + smartbaking);
        smartbankingRepository.save(smartbaking);

    }
    
}
