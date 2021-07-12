package co.com.banistmo.certification.contingencia.tasks;

import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.BTN_CONTINUE_TO_PROCESS;
import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.INPUT_EMAIL;
import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.INPUT_SMS;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.BTN_CONTINUE;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.BTN_EXECUTE_BATCH;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.GENERIC_CODE;
import static co.com.banistmo.certification.contingencia.utils.GeneralConstants.QUERY_SQL;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import co.com.banistmo.certification.contingencia.integrations.ConsultarBDCtg;
import co.com.banistmo.certification.contingencia.models.User;
import java.util.List;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SendToProcess implements Task {

  private User data;
  private boolean correctCodes;
  private int attempts;

  public SendToProcess(List<User> dataList) {
    this.data = dataList.get(0);
    correctCodes = true;
    attempts = 1;
  }

  public static SendToProcess withDoubleFactor(List<User> dataList) {
    return Tasks.instrumented(SendToProcess.class, dataList);
  }

  public SendToProcess withIncorrectCodes() {
    correctCodes = false;
    data.setAuthenticationPart_1(GENERIC_CODE);
    data.setAuthenticationPart_2(GENERIC_CODE);
    return this;
  }

  public SendToProcess nTimes() {
    attempts = 5;
    return this;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        WaitUntil.the(BTN_CONTINUE, isVisible()),
        Click.on(BTN_CONTINUE),
        WaitUntil.the(BTN_EXECUTE_BATCH, isVisible()),
        Click.on(BTN_EXECUTE_BATCH),
        WaitUntil.the(BTN_CONTINUE_TO_PROCESS, isVisible()));
    if (correctCodes) {
      consultBDCodes();
    }
    System.out.println("CODIGO 1: " + data.getAuthenticationPart_1());
    System.out.println("CODIGO 2: " + data.getAuthenticationPart_2());
    for (int i = 0; i < attempts; i++) {
      System.out.println("*attempts = " + attempts + " *i =" + i);
      actor.attemptsTo(
          Enter.theValue(data.getAuthenticationPart_1()).into(INPUT_EMAIL),
          Enter.theValue(data.getAuthenticationPart_2()).into(INPUT_SMS),
          Click.on(BTN_CONTINUE_TO_PROCESS)
      );
    }

  }

  private void consultBDCodes() {
    ConsultarBDCtg objConsulta = new ConsultarBDCtg();
    String codes = objConsulta.consultarIdclienteIdProducto(QUERY_SQL);
    data.setAuthenticationPart_1(codes.split("-")[0]);
    data.setAuthenticationPart_2(codes.split("-")[1]);
  }
}
