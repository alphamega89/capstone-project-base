package newaccount.domain;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.persistence.*;
import lombok.Data;
import newaccount.PreapplyApplication;
import newaccount.domain.PreAppliedE;

@Entity
@Table(name = "PreApply_table")
@Data
public class PreApplicationA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String appliedStatus;

    private String custNo;

    private String regNo;

    @PostPersist
    public void onPostPersist() {
        PreAppliedE preAppliedE = new PreAppliedE(this);
         
        preAppliedE.publishAfterCommit();
       
        // PreApplicationA preappliationA = new PreApplicationA();

        System.out.println("---사전신청-POST--------------------------------------------------------------------") ;
        System.out.println("고객번호 :" + preAppliedE.getCustNo());
        System.out.println("실명번호 :" + preAppliedE.getRegNo());
        System.out.println("상태정보 :" + preAppliedE.getAppliedStatus());
        System.out.println("------------------------------------------------------------------------") ;

       //  preappliationA.setAppliedStatus("사전검증");
       // repository().save(preappliationA); 


    }

    public static PreApplicationARepository repository() {
        PreApplicationARepository preApplicationARepository = PreapplyApplication.applicationContext.getBean(
            PreApplicationARepository.class
        );

        
        return preApplicationARepository;
    }

    public static void statusUpdateP(IncomeVerifiedE incomeVerifiedE) {

        System.out.println("---사전신청-소득검증 -> 소득검증 Policy -> 사전신청 policy ----------------------------------") ;
        System.out.println("고객번호 :" + incomeVerifiedE.getCustNo());
        System.out.println("실명번호 :" + incomeVerifiedE.getRegNo());
        System.out.println("상태정보 :" + incomeVerifiedE.getAppliedStatus());
        System.out.println("------------------------------------------------------------------------") ;


                // DATA 저장 
        // 사전신청시 무한루프 발생을 막기 위해서 findById로 정보를 가져옴 
        // Optional<PreApplicationA> preApplicationA = repository().findById(incomeVerifiedE.getId());
        // preApplicationA.ifPresent(preApplication -> {
        //     preApplication.setAppliedStatus("소득검증" );
        //     preApplication.setResNo(incomeVerifiedE.getResNo());
        //     preApplication.setCustNo(incomeVerifiedE.getCustNo());
        //     System.out.println("---사전신청--> 소득검증 Policy -> 사전신청 Policy  -(preApplicationA 저장값)---------------------------------") ;
        //     System.out.println("고객번호 :" + preApplication.getCustNo());
        //     System.out.println("실명번호 :" + preApplication.getResNo());
        //     System.out.println("상태정보 :" + preApplication.getAppliedStatus());
        //     System.out.println("------------------------------------------------------------------------") ;
        //     repository().save(preApplication);
        // });
        /** Example 1:  new item 
        PreApplicationA preApplicationA = new PreApplicationA();
        repository().save(preApplicationA);

        */

        /** Example 2:  finding and process
        
        repository().findById(incomeVerifiedE.get???()).ifPresent(preApplicationA->{
            
            preApplicationA // do something
            repository().save(preApplicationA);


         });
        */

    }

    public static void statusUpdateP(AccountOpenedE accountOpenedE) {

        System.out.println("---사전신청-> 계좌신설 -> 사전신청 Policy ----------------------------------") ;
        System.out.println("고객번호 :" + accountOpenedE.getCustNo());
        System.out.println("상태정보 :" + accountOpenedE.getAppliedStatus());
        System.out.println("------------------------------------------------------------------------") ;

        // DATA 저장 
        // 사전신청시 무한루프 발생을 막기 위해서 findById로 정보를 가져옴 
         //Optional<PreApplicationA> preApplicationA = repository().findById(accountOpenedE.getId());
         List<PreApplicationA> preApplicationA = repository().findByCustNo(accountOpenedE.getCustNo());
         PreApplicationA preApplicationa = preApplicationA.get(0);
         //preApplicationA.ifPresent(preApplication -> {
            preApplicationa.setAppliedStatus("청년희망 적금 가입이 완료되었어요!");
            preApplicationa.setCustNo(accountOpenedE.getCustNo());
             System.out.println("---사전신청--> 계좌신설 Policy -(preApplicationA 저장값)---------------------------------") ;
             System.out.println("고객번호 :" + preApplicationa.getCustNo());
             System.out.println("상태정보 :" + preApplicationa.getAppliedStatus());
             System.out.println("------------------------------------------------------------------------") ;
             repository().save(preApplicationa);
         //});

        /** Example 1:  new item 
        PreApplicationA preApplicationA = new PreApplicationA();
        repository().save(preApplicationA);

        */

        /** Example 2:  finding and process
        
        repository().findById(accountOpenedE.get???()).ifPresent(preApplicationA->{
            
            preApplicationA // do something
            repository().save(preApplicationA);


         });
        */

    }

    public static void statusUpdateP(PreAppliedE preAppliedE) {
    
        System.out.println("---사전신청--> 사전신청 Policy --(preAppliedE 저장값)-----------------------------") ;
        System.out.println("고객번호 :" + preAppliedE.getCustNo());
        System.out.println("실명번호 :" + preAppliedE.getRegNo());
        System.out.println("상태정보 :" + preAppliedE.getAppliedStatus());
        System.out.println("------------------------------------------------------------------------") ;
    
        // DATA 저장 
        // PreApplicationA preApplicationA = new PreApplicationA();
        // 사전신청시 무한루프 발생을 막기 위해서 findById로 정보를 가져옴 
        Optional<PreApplicationA> preApplicationA = repository().findById(preAppliedE.getId());
        preApplicationA.ifPresent(preApplication -> {
            preApplication.setAppliedStatus("사전신청" );
            preApplication.setCustNo(preAppliedE.getCustNo());
            preApplication.setRegNo(preAppliedE.getRegNo());
        
            System.out.println("---사전신청--> 사전신청 Policy -(preApplicationA 저장값)---------------------------------") ;
            System.out.println("고객번호 :" + preApplication.getCustNo());
            System.out.println("실명번호 :" + preApplication.getRegNo());
            System.out.println("상태정보 :" + preApplication.getAppliedStatus());
            System.out.println("------------------------------------------------------------------------") ;
            repository().save(preApplication);
        });
           
        
        
     

        /** Example 1:  new item 
        PreApplicationA preApplicationA = new PreApplicationA();
        repository().save(preApplicationA);

        */

        /** Example 2:  finding and process
        
        repository().findById(preAppliedE.get???()).ifPresent(preApplicationA->{
            
            preApplicationA // do something
            repository().save(preApplicationA);


         });
        */

    }
}
