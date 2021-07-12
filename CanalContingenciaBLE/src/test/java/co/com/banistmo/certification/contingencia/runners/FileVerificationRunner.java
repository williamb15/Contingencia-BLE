package co.com.banistmo.certification.contingencia.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/file_verification.feature",
    glue = "co.com.banistmo.certification.contingencia.stepdefinitions",
    snippets = SnippetType.CAMELCASE)

public class FileVerificationRunner {

}
