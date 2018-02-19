package nomura.com.utils;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"pretty", "html:target/cucumber-html-report"},
        features = {"src/test/resources/nomura/com/features/"},
        tags = {"@nomura"},
        strict = true,
        glue = {"classpath:"}
)

public class TestRunner {
}
