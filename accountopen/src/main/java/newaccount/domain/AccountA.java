package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import java.time.LocalDate;
import lombok.Data;
import newaccount.AccountopenApplication;
import newaccount.domain.AccountOpenedE;

@Entity
@Table(name = "AccountA_table")
@Data
public class AccountA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acctNo;

    private String custNo;

    private String openDate;

    private String accountStatus;

    private int accountBalance;

    @PostPersist
    public void onPostPersist() {
        AccountOpenedE accountOpenedE = new AccountOpenedE(this);
        
        accountOpenedE.publishAfterCommit();
    }

    public static AccountARepository repository() {
        AccountARepository accountARepository = AccountopenApplication.applicationContext.getBean(
            AccountARepository.class
        );
        return accountARepository;
    }

    public static void createAccount(IncomeVerifiedE incomeVerifiedE) {
        //** Example 1:  new item */
        AccountA accountA = new AccountA();
        if(incomeVerifiedE.getVerifyResult().equals("Y")){

            accountA.setAccountStatus("OPEN");
            accountA.setAcctNo("12345678901234567890");
            accountA.setAccountBalance(0);
            accountA.setCustNo(incomeVerifiedE.getCustNo());
            
            accountA.setOpenDate(LocalDate.now().toString());
            repository().save(accountA); 
            System.out.println("계좌생성완료");
        }        
        else
        {
            System.out.println("소득검증결과 신규불가합니다. 소득 " + incomeVerifiedE.getIncomeAmount());
            return;
        }             
        
       //repository().save(accountA); 
       
    }
}
