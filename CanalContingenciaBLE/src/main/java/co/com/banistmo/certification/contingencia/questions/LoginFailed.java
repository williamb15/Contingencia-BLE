package co.com.banistmo.certification.contingencia.questions;

import static co.com.banistmo.certification.contingencia.userinterfaces.DoubleFactorElements.LABEL_ERROR_TOKEN_ATTEPMTS;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class LoginFailed implements Question<String> {

  public static LoginFailed withMessage() {
    return new LoginFailed();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(LABEL_ERROR_TOKEN_ATTEPMTS, WebElementStateMatchers.isVisible())
    );
    return Text.of(LABEL_ERROR_TOKEN_ATTEPMTS).viewedBy(actor).asString();
  }
}
