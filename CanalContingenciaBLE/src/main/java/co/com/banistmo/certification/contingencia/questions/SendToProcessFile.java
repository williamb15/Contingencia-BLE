package co.com.banistmo.certification.contingencia.questions;


import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.BUTTON_ACCEPT;
import static co.com.banistmo.certification.contingencia.userinterfaces.TransactionsElements.MESSAGE_SATISFACTORY_DELIVERY;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SendToProcessFile implements Question<String> {

  public static SendToProcessFile withMessage() {
    return new SendToProcessFile();
  }


  @Override
  public String answeredBy(Actor actor) {
    return Text.of(MESSAGE_SATISFACTORY_DELIVERY).viewedBy(actor).asString();
  }


}
