package co.com.banistmo.certification.contingencia.tasks;

import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.BTN_CONTINUE_TO_PROCESS;
import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.INPUT_EMAIL;
import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.INPUT_SMS;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.BTN_CONTINUE;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.BTN_EXECUTE_BATCH;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.GENERIC_CODE;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.QUERY_SQL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.banistmo.certification.contingencia.integrations.ConsultarBDCtg;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class DoubleFactor implements Task {

  private String authenticationPart_1;
  private String authenticationPart_2;
  private boolean correctCodes;
  private int attempts;
  private boolean fromLogin;

  public DoubleFactor() {
    correctCodes = true;
    fromLogin = false;
    attempts = 1;
  }

  public static DoubleFactor withCodes() {
    return Tasks.instrumented(DoubleFactor.class);
  }

  public DoubleFactor withIncorrectCodes() {
    correctCodes = false;
    authenticationPart_1 = GENERIC_CODE;
    authenticationPart_2 = GENERIC_CODE;
    return this;
  }

  public DoubleFactor fromLogin() {
    fromLogin = true;
    return this;
  }

  public DoubleFactor nTimes() {
    attempts = 4;
    return this;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Check.whether(!fromLogin).andIfSo(
            WaitUntil.the(BTN_CONTINUE, isVisible()),
            Click.on(BTN_CONTINUE),
            WaitUntil.the(BTN_EXECUTE_BATCH, isVisible()),
            Click.on(BTN_EXECUTE_BATCH),
            WaitUntil.the(BTN_CONTINUE_TO_PROCESS, isVisible())
        )
    );
    if (correctCodes) {
      consultBDCodes();
    }
    for (int i = 0; i < attempts; i++) {
      actor.attemptsTo(
          WaitUntil.the(INPUT_EMAIL, isEnabled()),
          Enter.theValue(authenticationPart_1).into(INPUT_EMAIL),
          Enter.theValue(authenticationPart_2).into(INPUT_SMS),
          Click.on(BTN_CONTINUE_TO_PROCESS)
      );
    }
  }

  private void consultBDCodes() {
    ConsultarBDCtg objConsulta = new ConsultarBDCtg();
    String codes = objConsulta.consultarIdclienteIdProducto(QUERY_SQL);
    authenticationPart_1 = codes.split("-")[0];
    authenticationPart_2 = codes.split("-")[1];
  }
}
