package newaccount.common;

import io.cucumber.spring.CucumberContextConfiguration;
import newaccount.AccountopenApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { AccountopenApplication.class })
public class CucumberSpingConfiguration {}
