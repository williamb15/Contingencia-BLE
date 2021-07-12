package co.com.banistmo.certification.contingencia.stepdefinitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

import co.com.banistmo.certification.contingencia.models.User;
import co.com.banistmo.certification.contingencia.questions.SendToProcessFile;
import co.com.banistmo.certification.contingencia.tasks.ContinueToProcess;
import co.com.banistmo.certification.contingencia.tasks.DoubleFactor;
import co.com.banistmo.certification.contingencia.tasks.VerifyBatch;
import co.com.banistmo.certification.contingencia.utils.GeneralConstants;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

public class BatchProcessingStepDefinition {

    @When("^the User validates and sends a file to be processed$")
    public void theUserValidatesAndSendsAFileToBeProcessed(List<User> data) {
        theActorInTheSpotlight().attemptsTo(
                VerifyBatch.withFile(data),
                DoubleFactor.withCodes(),
                ContinueToProcess.fileBatch()
        );
    }

    @Then("^he can display the correct delivery message with the execution number$")
    public void heCanDisplayTheCorrectDeliveryMessageWithTheExecutionNumber() {
        theActorInTheSpotlight()
                .should(seeThat(SendToProcessFile.withMessage(),
                        equalTo(GeneralConstants.FILE_PROCESSED_SUCCESSFULLY))
                );
    }
}
