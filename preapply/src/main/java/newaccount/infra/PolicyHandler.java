package newaccount.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import newaccount.config.kafka.KafkaProcessor;
import newaccount.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    PreApplicationARepository preApplicationARepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverIncomeVerifiedE_StatusUpdateP(
        @Payload IncomeVerifiedE incomeVerifiedE
    ) {
        if (!incomeVerifiedE.validate()) return;
        IncomeVerifiedE event = incomeVerifiedE;
        System.out.println(
            "\n\n##### listener StatusUpdateP : " +
            incomeVerifiedE.toJson() +
            "\n\n"
        );

        // Sample Logic //
        PreApplicationA.statusUpdateP(event);
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverAccountOpenedE_StatusUpdateP(
        @Payload AccountOpenedE accountOpenedE
    ) {
        if (!accountOpenedE.validate()) return;
        AccountOpenedE event = accountOpenedE;
        System.out.println(
            "\n\n##### listener StatusUpdateP : " +
            accountOpenedE.toJson() +
            "\n\n"
        );

        // Sample Logic //
        PreApplicationA.statusUpdateP(event);
    }

    
    
    // keep

}
