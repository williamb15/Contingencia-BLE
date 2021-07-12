package co.com.banistmo.certification.contingencia.stepdefinitions;

import static co.com.banistmo.certification.contingencia.utils.ExceptionConstants.LOGIN_ERROR;
import static co.com.banistmo.certification.contingencia.utils.LoginConstants.ERROR_LOGIN_MESSAGE;
import static co.com.banistmo.certification.contingencia.utils.LoginConstants.ERROR_MESSAGE;
import static co.com.banistmo.certification.contingencia.utils.LoginConstants.WELCOME_MESSAGE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import co.com.banistmo.certification.contingencia.exceptions.GeneralException;
import co.com.banistmo.certification.contingencia.models.User;
import co.com.banistmo.certification.contingencia.questions.IncorrectLogin;
import co.com.banistmo.certification.contingencia.questions.LoginFailed;
import co.com.banistmo.certification.contingencia.questions.SuccessfulLogin;
import co.com.banistmo.certification.contingencia.tasks.DoubleFactor;
import co.com.banistmo.certification.contingencia.tasks.Login;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class LoginStepDefinition extends GeneralStepDefinition {

    @Before
    public void config() {
        setUp();
    }

    @When("^the User enters with the correct credentials$")
    public void theUserEntersWithTheCorrectCredentials(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(
                Login.inTheWeb(credentials.get(0)),
                DoubleFactor.withCodes().fromLogin()
        );
    }

    @When("^the User enters with the incorrect credentials$")
    public void theUserEntersWithTheIncorrectCredentials(List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(
                Login.inTheWeb(credentials.get(0))
        );
    }

    @When("^the User enters with the credentials and exceeds double factor attempts$")
    public void theUserEntersWithTheCredentialsAndExceedsDoubleFactorAttempts(
            List<User> credentials) {
        theActorInTheSpotlight().attemptsTo(
                Login.inTheWeb(credentials.get(0)),
                DoubleFactor.withCodes().fromLogin().withIncorrectCodes().nTimes()
        );

    }

    @Then("^he will verify that he  he no enters the channel by attempts$")
    public void heWillVerifyThatHeHeNoEntersTheChannelByAttempts() {
        theActorInTheSpotlight()
                .should(seeThat(LoginFailed.withMessage(),
                        containsString(ERROR_LOGIN_MESSAGE))
                        .orComplainWith(GeneralException.class, LOGIN_ERROR));
    }

    @Then("^he will verify that he successfully enters the channel$")
    public void heWillVerifyThatHeSuccessfullyEntersTheChannel() {
        theActorInTheSpotlight()
                .should(seeThat(SuccessfulLogin.withMessage(),
                        containsString(WELCOME_MESSAGE))
                        .orComplainWith(GeneralException.class, LOGIN_ERROR));
    }

    @Then("^he will verify that he no enters the channel$")
    public void heWillVerifyThatHeNoEntersTheChannel() {
        theActorInTheSpotlight()
                .should(seeThat(IncorrectLogin.withMessage(),
                        containsString(ERROR_MESSAGE))
                        .orComplainWith(GeneralException.class, LOGIN_ERROR));
    }
}
