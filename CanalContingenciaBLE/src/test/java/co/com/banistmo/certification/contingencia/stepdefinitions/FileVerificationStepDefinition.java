package co.com.banistmo.certification.contingencia.stepdefinitions;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.banistmo.certification.contingencia.models.User;
import co.com.banistmo.certification.contingencia.questions.ValidationFile;
import co.com.banistmo.certification.contingencia.tasks.DoubleFactor;
import co.com.banistmo.certification.contingencia.tasks.Login;
import co.com.banistmo.certification.contingencia.tasks.VerifyBatch;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class FileVerificationStepDefinition {

    @Given("^the user is logged into the application$")
    public void theUserIsLoggedIntoTheApplication(List<User> data) {
        theActorInTheSpotlight().wasAbleTo(
                Login.inTheWeb(data.get(0)),
                DoubleFactor.withCodes().fromLogin()
        );
    }

    @When("^the User uploads the correct file$")
    public void theUserUploadsTheFile(List<User> data) {
        theActorInTheSpotlight().attemptsTo(
                VerifyBatch.withFile(data)
        );
    }

    @When("^the User uploads the incorect file$")
    public void theUserUploadsTheIncorrectFile(List<User> data) {
        theActorInTheSpotlight().attemptsTo(
                VerifyBatch.withFile(data)
        );
    }

    @Then("^will verify that the status of the batch is (.*)$")
    public void willVerifyThatTheStatusOftheBathIs(String status) {
        theActorInTheSpotlight()
                .should(seeThat(ValidationFile.withMessage(),
                        equalTo(status)));
    }
}
