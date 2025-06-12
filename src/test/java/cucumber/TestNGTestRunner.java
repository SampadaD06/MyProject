package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//cucumber->  TestNG, junit
//tags = "@Regression"
@CucumberOptions(features="src/test/java/cucumber",glue="testProject.stepDefinitions",
monochrome=true,tags = "@tag", plugin= {"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	
}
