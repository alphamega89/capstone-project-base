package msalogin.domain;

import java.io.IOException;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImp implements AccountService {

    @Autowired
    private final AccountRepository accountRepository;

    //계좌 신규 (int customerId, String accountNo, String accountBal, String accountStatus, String trnsCode)
    public void createAccount (int customerId){
        System.out.println("#########Account Service : Start Create Account#######");
        //신규된 고객 obj 확인
        Optional<Account> accountOptional = accountRepository.findBycustomerId(customerId);
        Account accountCust = accountOptional.get();
        //계좌 신규 가입 정보 셋팅
        
        //계좌번호 셋팅
        String firstNum = "111";
        String midNum = Integer.toString(customerId);
        String lastNum = "99999";

        String accountNum = firstNum + midNum + lastNum;

        accountCust.setAccountNo(accountNum);

        //계좌잔액 셋팅
        Double firstbal = 0.0;
        accountCust.setAccountBal(firstbal);

        //계좌상태 셋팅
        String firstStatus = "1";
        accountCust.setAccountStatus(firstStatus);

        //거래 구분 코드 셋팅
        String firstTransCode = "0";
        accountCust.setTrnsCode(firstTransCode);

        // DB저장
        System.out.println("#########Account Service : Create Account Obj#######"+ accountCust);
        accountRepository.save(accountCust);

        //EVT발행
        AccountUpdated accountUpdated = new AccountUpdated();
        accountUpdated.setCustomerId(customerId);
        accountUpdated.setAccountNo(accountNum);
        accountUpdated.setAccountBal(firstbal);
        accountUpdated.setAccountStatus(firstStatus);
        accountUpdated.publishAfterCommit();

    }


    //계좌 해지
    public void deleteAccount (int customerId){
        System.out.println("#########Account Service : Start delete Account#######");
        //고객 obj 확인
        Optional<Account> accountOptional = accountRepository.findBycustomerId(customerId);
        Account accountCust = accountOptional.get();
        
        //계좌상태 셋팅
        String deleteStatus = "9";
        accountCust.setAccountStatus(deleteStatus);

        // DB저장
        System.out.println("#########Account Service : delete Account Obj#######"+ accountCust);
        accountRepository.save(accountCust);

        //EVT발행
        AccountUpdated accountUpdated = new AccountUpdated();
        accountUpdated.setCustomerId(customerId);
        accountUpdated.setAccountStatus(deleteStatus);
        accountUpdated.publishAfterCommit();

    }

    //조회
    public Account getAccount(int customerId){
        System.out.println("#########Account Service : Start Check Account#######");
        //고객 obj 확인
        Optional<Account> accountOptional = accountRepository.findBycustomerId(customerId);
        Account accountCust = accountOptional.get();

        return accountCust;
    }

    //계좌 입금
    public void depositAccount(int customerId, Double money){
        System.out.println("#########Account Service : Start deposit Account#######");
        //고객 obj 확인
        Optional<Account> accountOptional = accountRepository.findBycustomerId(customerId);
        Account accountCust = accountOptional.get();

        //기존 잔액 조회 
        Double previousBal = accountCust.getAccountBal();
        //신규 잔액 셋팅
        Double newAccountBal = money + previousBal;
        accountCust.setAccountBal(newAccountBal);
        //DB저장
        accountRepository.save(accountCust);

        //EVT발행
        AccountUpdated accountUpdated = new AccountUpdated();
        accountUpdated.setCustomerId(customerId);
        accountUpdated.setAccountNo(accountCust.getAccountNo());
        accountUpdated.setAccountBal(newAccountBal);
        String trsCd = "1"; //1: 입금 2: 출금
        accountUpdated.setTrnsCode(trsCd);
        accountUpdated.publishAfterCommit();

        System.out.println("#########Account Service : End deposit Account#######");

    }

    //계좌 출금
    public void withdrawAccount(int customerId, Double money){
        System.out.println("#########Account Service : Start deposit Account#######");
        //고객 obj 확인
        Optional<Account> accountOptional = accountRepository.findBycustomerId(customerId);
        Account accountCust = accountOptional.get();
    
        //기존 잔액 조회 
        Double previousBal = accountCust.getAccountBal();
        
        //기존 잔액이 출금 요청금액이 큰 경우가 정상 로직
        if(previousBal >= money){    
            //신규 잔액 셋팅
            Double newAccountBal = previousBal - money;
            accountCust.setAccountBal(newAccountBal);
            //DB저장
            accountRepository.save(accountCust);

            //EVT발행
            AccountUpdated accountUpdated = new AccountUpdated();
            accountUpdated.setCustomerId(customerId);
            accountUpdated.setAccountNo(accountCust.getAccountNo());
            accountUpdated.setAccountBal(newAccountBal);
            String trsCd = "2"; //1: 입금 2: 출금
            accountUpdated.setTrnsCode(trsCd);
            accountUpdated.publishAfterCommit();
        }else{
            //에러메서지 출력
            System.out.println("#########잔액이 부족합니다.#######");
        }

        System.out.println("#########Account Service : End deposit Account#######");

        }
    
    public Account save(String data){
        ObjectMapper mapper = new ObjectMapper();
        Account accountCust = null;
        try {
            accountCust = mapper.readValue(data, Account.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        /*
        List<CustomerOption> customerOptions = customer.getCustomerOptions();
        for(CustomerOption c : customerOptions){
            c.setCustomerId(customer);
        }
        
         */
        return accountRepository.save(accountCust);

    }


}

