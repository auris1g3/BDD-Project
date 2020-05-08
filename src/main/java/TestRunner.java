
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        //tags = {"@Smoke"},
        features = "src/test/resources",
        glue = {"steps"},
        plugin = {"pretty", "html:target/htmlreports"}
)

public class TestRunner {
}
