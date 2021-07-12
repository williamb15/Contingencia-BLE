package co.com.banistmo.certification.contingencia.stepdefinitions;

import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.LABEL_GENERAL_INFO;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.containsString;

import co.com.banistmo.certification.contingencia.models.User;
import co.com.banistmo.certification.contingencia.questions.IncorrectLogin;
import co.com.banistmo.certification.contingencia.questions.InquiriesValidation;
import co.com.banistmo.certification.contingencia.tasks.ContinueToProcess;
import co.com.banistmo.certification.contingencia.tasks.QueryBatch;
import co.com.banistmo.certification.contingencia.tasks.QueryProcessFile;
import co.com.banistmo.certification.contingencia.tasks.DoubleFactor;
import co.com.banistmo.certification.contingencia.tasks.VerifyBatch;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

public class ResultsQueryStepDefinition {

  @When("^the User validates and sends a file to be processed and query by process number$")
  public void theUserValidatesAndSendsAFileToBeProcessedAndQueryByProcessNumber(List<User> data) {
    theActorInTheSpotlight().attemptsTo(
        VerifyBatch.withFile(data),
        DoubleFactor.withCodes(),
        ContinueToProcess.fileBatch(),
        QueryBatch.withNumber()
    );
  }

  @When("^the User enter the query module and search by type of transaction$")
  public void theUserEnterTheQueryModuleAndSearchByTypeOfTransaction() {
    theActorInTheSpotlight().attemptsTo(
        QueryProcessFile.byTransaction()
    );
  }

  @Then("^he can see the information of the processed file$")
  public void heCanSeeTheInformationOfTheProcessedFile() {
    theActorInTheSpotlight()
        .should(seeThat(InquiriesValidation.withMessage(),
            containsString(LABEL_GENERAL_INFO)));
  }
}
