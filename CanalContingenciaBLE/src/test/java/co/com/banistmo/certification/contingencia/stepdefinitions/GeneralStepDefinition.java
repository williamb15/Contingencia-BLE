package co.com.banistmo.certification.contingencia.stepdefinitions;

import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.CHROME;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.USER;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import co.com.banistmo.certification.contingencia.utils.GeneralConstants;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;


public class GeneralStepDefinition {

  @Managed(driver = CHROME)
  protected WebDriver hisBrowser;

  @SuppressWarnings("unchecked")
  public void setUp() {
    setTheStage(new Cast());
    theActorCalled(USER);
    theActorInTheSpotlight().can(BrowseTheWeb.with(hisBrowser));
    theActorInTheSpotlight().wasAbleTo(Open.url(GeneralConstants.CERTIFICATION_URL));
  }
}