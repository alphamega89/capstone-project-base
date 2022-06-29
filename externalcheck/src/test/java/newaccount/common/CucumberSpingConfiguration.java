package newaccount.common;

import io.cucumber.spring.CucumberContextConfiguration;
import newaccount.ExternalcheckApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { ExternalcheckApplication.class })
public class CucumberSpingConfiguration {}
