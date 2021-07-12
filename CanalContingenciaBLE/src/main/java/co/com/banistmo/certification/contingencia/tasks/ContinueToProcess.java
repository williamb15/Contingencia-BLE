package co.com.banistmo.certification.contingencia.tasks;

import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.BUTTON_ACCEPT;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.MESSAGE_SATISFACTORY_DELIVERY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class ContinueToProcess implements Task {

  public static ContinueToProcess fileBatch() {
    return Tasks.instrumented(ContinueToProcess.class);
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(BUTTON_ACCEPT, isVisible()),
        WaitUntil.the(BUTTON_ACCEPT, isEnabled()),
        Click.on(BUTTON_ACCEPT),
        WaitUntil.the(MESSAGE_SATISFACTORY_DELIVERY, isVisible())
    );
  }
}
