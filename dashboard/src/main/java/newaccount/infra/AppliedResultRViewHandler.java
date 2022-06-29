package newaccount.infra;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import newaccount.config.kafka.KafkaProcessor;
import newaccount.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class AppliedResultRViewHandler {

    @Autowired
    private AppliedResultRRepository appliedResultRRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPreAppliedE_then_CREATE_1(
        @Payload PreAppliedE preAppliedE
    ) {
        try {
            if (!preAppliedE.validate()) return;

            // view 객체 생성
            AppliedResultR appliedResultR = new AppliedResultR();
            // view 객체에 이벤트의 Value 를 set 함
            appliedResultR.setId(preAppliedE.getId());
            appliedResultR.setCustNo(preAppliedE.getCustNo());
            appliedResultR.setAppliedStatus(preAppliedE.getAppliedStatus());
            // view 레파지 토리에 save
            appliedResultRRepository.save(appliedResultR);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccountOpenedE_then_UPDATE_1(
        @Payload AccountOpenedE accountOpenedE
    ) {
        try {
            if (!accountOpenedE.validate()) return;
            // view 객체 조회

            AppliedResultR appliedResultR = appliedResultRRepository.findByCustNo(
                accountOpenedE.getCustNo()
            );
            
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                appliedResultR.setAppliedStatus(
                    accountOpenedE.getAppliedStatus()
                );
                // view 레파지 토리에 save
                appliedResultRRepository.save(appliedResultR);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenPreAppliedE_then_UPDATE_2(
        @Payload PreAppliedE preAppliedE
    ) {
        try {
            if (!preAppliedE.validate()) return;
            // view 객체 조회

            AppliedResultR appliedResultR = appliedResultRRepository.findByCustNo(
                preAppliedE.getCustNo()
            );
            
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                appliedResultR.setAppliedStatus(preAppliedE.getAppliedStatus());
                // view 레파지 토리에 save
                appliedResultRRepository.save(appliedResultR);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenIncomeVerifiedE_then_UPDATE_3(
        @Payload IncomeVerifiedE incomeVerifiedE
    ) {
        try {
            if (!incomeVerifiedE.validate()) return;
            // view 객체 조회

            AppliedResultR appliedResultR = appliedResultRRepository.findByCustNo(
                incomeVerifiedE.getCustNo()
            );
            
                // view 객체에 이벤트의 eventDirectValue 를 set 함
                appliedResultR.setAppliedStatus(
                    incomeVerifiedE.getAppliedStatus()
                );
                // view 레파지 토리에 save
                appliedResultRRepository.save(appliedResultR);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // keep

}
