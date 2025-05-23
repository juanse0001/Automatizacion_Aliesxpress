package co.com.AutoFacebook.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {
                "co.com.AutoFacebook.stepsdefinitions",
                "co.com.AutoFacebook.utils.hooks"
        },
        snippets = SnippetType.CAMELCASE,
        tags = "@aliExpressSearch"
)
public class AliExpressTestRunner {

}