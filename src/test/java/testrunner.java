/**
 * @author Saquib Kazi
 * 
 * This Class will run test cases with testNG
 * 
 */


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;




@CucumberOptions(monochrome = true,features="src/test/resources/features",
		glue= {"stepdefinition"},
		plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
 		/*,tags = "@MyAccount"*/)
public class testrunner extends AbstractTestNGCucumberTests {
	
}