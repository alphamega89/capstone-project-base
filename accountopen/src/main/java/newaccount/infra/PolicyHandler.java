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
    AccountARepository accountARepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverIncomeVerifiedE_CreateAccount(
        @Payload IncomeVerifiedE incomeVerifiedE
    ) {
        if (!incomeVerifiedE.validate()) return;
        IncomeVerifiedE event = incomeVerifiedE;
        System.out.println(
            "\n\n##### listener CreateAccount : " +
            incomeVerifiedE.toJson() +
            "\n\n"
        );

        // Comments //
        //합격되면 계좌생성

        // Sample Logic //
        AccountA.createAccount(event);
    }
    // keep

}
