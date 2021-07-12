package co.com.banistmo.certification.contingencia.questions;

import static co.com.banistmo.certification.contingencia.userinterfaces.HomePageElements.WELCOME_MSJ;
import static co.com.banistmo.certification.contingencia.userinterfaces.InquiriesElements.GENERAL_INFO;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class InquiriesValidation implements Question<String> {

  public static InquiriesValidation withMessage() {
    return new InquiriesValidation();
  }

  @Override
  public String answeredBy(Actor actor) {
    actor.attemptsTo(
        WaitUntil.the(GENERAL_INFO, WebElementStateMatchers.isVisible())
    );
    return Text.of(GENERAL_INFO).viewedBy(actor).asString();
  }

}
