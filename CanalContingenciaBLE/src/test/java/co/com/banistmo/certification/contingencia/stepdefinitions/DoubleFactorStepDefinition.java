package co.com.banistmo.certification.contingencia.stepdefinitions;


import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.LABEL_ERROR_TOKEN;
import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.LABEL_ERROR_TOKEN_ATTEPMTS;
import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.MSJ_FILE_PROCESSED_SUCCESFUL;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.FILE_SEND_TO_PROCESS;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.MSJ_TOKEN_ERROR;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.MSJ_TOKEN_ERROR_ATTEMPTS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.banistmo.certification.contingencia.models.User;
import co.com.banistmo.certification.contingencia.questions.DoubleFactorValidation;
import co.com.banistmo.certification.contingencia.tasks.DoubleFactor;
import co.com.banistmo.certification.contingencia.tasks.VerifyBatch;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

public class DoubleFactorStepDefinition {

  @When("^the User validates a correct file and enters the correct codes$")
  public void theUserValidatesACorrectFileAndEntersTheCorrectCodes(List<User> data) {
    theActorInTheSpotlight().attemptsTo(
        VerifyBatch.withFile(data),
        DoubleFactor.withCodes()
    );

  }

  @Then("^he sends to process a file correctly$")
  public void heSendsToProcessAFileCorrectly() {
    theActorInTheSpotlight()
        .should(seeThat(DoubleFactorValidation.withMessage(MSJ_FILE_PROCESSED_SUCCESFUL),
            equalTo(FILE_SEND_TO_PROCESS)));
  }

  @When("^the User validates a correct file and enters the wrong codes$")
  public void theUserValidatesACorrectFileAndEntersTheWrongCodes(List<User> data) {
    theActorInTheSpotlight().attemptsTo(
        VerifyBatch.withFile(data),
        DoubleFactor.withCodes().withIncorrectCodes()
    );
  }

  @Then("^he displays an error message$")
  public void heDisplaysAnErrorMessage() {
    theActorInTheSpotlight()
        .should(seeThat(DoubleFactorValidation.withMessage(LABEL_ERROR_TOKEN),
            equalTo(MSJ_TOKEN_ERROR)));
  }

  @When("^the User validates a correct file and enters the incorrect codes four times$")
  public void theUserValidatesACorrectFileAndEntersTheIncorrectCodesFourTimes(List<User> data) {
    theActorInTheSpotlight().attemptsTo(
        VerifyBatch.withFile(data),
        DoubleFactor.withCodes().withIncorrectCodes().nTimes()
    );
  }

  @Then("^He sees 'Maximos Intentos Permitidos' message$")
  public void heSeesMaximosIntentosPermitidosMessage() {
    theActorInTheSpotlight()
        .should(seeThat(DoubleFactorValidation.withMessage(LABEL_ERROR_TOKEN_ATTEPMTS),
            equalTo(MSJ_TOKEN_ERROR_ATTEMPTS))
        );
  }
}