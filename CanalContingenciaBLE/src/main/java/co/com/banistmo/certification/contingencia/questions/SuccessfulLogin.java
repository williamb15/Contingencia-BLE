package co.com.banistmo.certification.contingencia.questions;


import static co.com.banistmo.certification.contingencia.userinterfaces.HomePageElements.WELCOME_MSJ;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SuccessfulLogin implements Question<String> {

  public static SuccessfulLogin withMessage() {
    return new SuccessfulLogin();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(WELCOME_MSJ, WebElementStateMatchers.isVisible())
    );
    return Text.of(WELCOME_MSJ).viewedBy(actor).asString();
  }
}
