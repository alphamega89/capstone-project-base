package newaccount.common;

import io.cucumber.spring.CucumberContextConfiguration;
import newaccount.PreapplyApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { PreapplyApplication.class })
public class CucumberSpingConfiguration {}
