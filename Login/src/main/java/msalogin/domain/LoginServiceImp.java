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
public class LoginServiceImp implements LoginService{
    
    @Autowired
    private final LoginRepository loginRepository;
    
    //스마트폰뱅킹 ID& Password 검증
    public void loginValidate (String bankingId, String password){
        System.out.println("#########Login Service : Start check ID&&&&PASSWORD#######");

        //고객번호로 banking id && password obj 확인
        Optional<Login> loginOptional = loginRepository.findBybankingId(bankingId);
        Login logintCust = loginOptional.get();
        
        //로그인 상태 초기값 셋팅 = null
        Boolean isLoginStatus = logintCust.getIslogin();
        System.out.println("#########Login Status#######" + isLoginStatus);

        //ID일치 여부 확인
        if(bankingId.equals(logintCust.getBankingId())){
            System.out.println("#########Login Service : Correct ID#######");
            //password 일치여부 확인
            if(password.equals(logintCust.getPassword())){
                System.out.println("#########Login Service : Correct ID&&&&PASSWORD#######");
                isLoginStatus = true;
                logintCust.setIslogin(isLoginStatus);
                loginRepository.save(logintCust);
            }
            else{
                System.out.println("#########Login Service : Fail to login, password is incorrect#######");
                isLoginStatus = false;
                logintCust.setIslogin(isLoginStatus);
                loginRepository.save(logintCust);
            }
        }
        else{
            System.out.println("#########Login Service : inCorrect ID#######");
            isLoginStatus = false;
            logintCust.setIslogin(isLoginStatus);
            loginRepository.save(logintCust);
        }

    }       

}




